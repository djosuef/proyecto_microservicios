package com.aulamatriz.ms.management.ms_user.controller.v2;

import com.aulamatriz.ms.management.ms_user.controller.v2.docs.IUserDoc;
import com.aulamatriz.ms.management.ms_user.dto.UserDto;
import com.aulamatriz.ms.management.ms_user.exception.MyHandleException;
import com.aulamatriz.ms.management.ms_user.service.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v2/users")
public class UserControllerV2 implements IUserDoc {

    private final IUserService userService;

    @Override
    public ResponseEntity<?> create(@Valid UserDto userDto) {
        return this.userService.create(userDto);

    }

    @Override
    public ResponseEntity<?> division(int valor1, int valor2) throws Exception {
        if(valor2 == 0){
            throw new MyHandleException("No se puede dividir por cero");
        } else if (valor2==-1) {
            throw new Exception("No se puede dividir negativo");
        }
        var result = valor1 / valor2;
        return ResponseEntity.ok(result);
    }
}
