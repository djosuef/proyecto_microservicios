package com.aulamatriz.ms.management.ms_user.service;

import com.aulamatriz.ms.management.ms_user.dto.UserDto;
import com.aulamatriz.ms.management.ms_user.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<?> create(UserDto userDto);

    ResponseEntity<List<UserEntity>> findAll();

    ResponseEntity<?> delete(Long id);
}
