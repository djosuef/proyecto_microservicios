package com.aulamatriz.ms.management.ms_user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank
    @Size(min = 0, max = 20,message = "el nombre no debe tener mas de 20 caracteres")
    @Pattern(regexp = "^[^0-9]*$", message = "El nombre no puede contener numeros")
    private String name;
    @NotBlank
    @Email(message = "el email debe ser valido , @")
    @Size(min = 0, max = 30 ,message = "el email no debe tener mas de 30 caracteres")
    private String email;
    @NotBlank
    @Size(min = 0, max = 12)
    @Pattern(regexp = "\\d+", message = "El documento solo permite números")
    private String document;
    @NotBlank
    @Pattern(regexp = "CC|CE", message = "El tipo de documento debe ser CC o CE.")
    private String typeDocument;
}
