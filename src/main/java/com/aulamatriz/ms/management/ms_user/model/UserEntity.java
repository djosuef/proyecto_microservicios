package com.aulamatriz.ms.management.ms_user.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;
    private String email;
    private String document;

    private String typeDocument;

    public UserEntity(String name, String email, String document, String typeDocument) {
        this.document = document;
        this.email = email;
        this.typeDocument=typeDocument;
        this.name = name;
    }
}
