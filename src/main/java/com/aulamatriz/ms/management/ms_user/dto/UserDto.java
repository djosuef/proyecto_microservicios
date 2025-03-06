package com.aulamatriz.ms.management.ms_user.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String document;
    private String typeDocument;
}
