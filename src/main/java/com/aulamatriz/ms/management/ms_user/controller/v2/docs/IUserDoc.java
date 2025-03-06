package com.aulamatriz.ms.management.ms_user.controller.v2.docs;

import com.aulamatriz.ms.management.ms_user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "User-api", description = "crud basico de usuarios")
@RequestMapping("/v2/user")
public interface IUserDoc {

    @Operation(summary = "Crear nuevo usaurio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado"),
            @ApiResponse(responseCode = "500", description = "Error desarrollo"),
            @ApiResponse(responseCode = "404", description = "EndPoint no encontrado")
    })
    @PostMapping
    ResponseEntity<?> create(@RequestBody UserDto userDto);
}
