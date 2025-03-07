package com.aulamatriz.ms.management.ms_user.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class HandleException {

    //@Value("${control.my-exceptionb}")
    //private final String bussinesError;

    @Value("${control.my-exception}")
    private String sistemError;


    //metodo para el manejo de errores no controlados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptionMethod(Exception e){
        var error = sistemError + " Negativo " + e.getMessage();
        log.error(error);
        return ResponseEntity
                .badRequest()
                .body(error);
    }

    //metodo para el manejo de errores controlados

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<String> myHandleExceptionMethod(Exception e){
        var error = sistemError + e.getMessage();
        log.error(error);
        return ResponseEntity
                .badRequest()
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleExceptionArgument(MethodArgumentNotValidException ex){
        List<String> errorList = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()
             ) {errorList.add(error.getObjectName() + ": " + error.getField() + ": " + error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errorList);
    }
}
