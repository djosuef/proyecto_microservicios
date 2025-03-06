package com.aulamatriz.ms.management.ms_user.service.impl;

import com.aulamatriz.ms.management.ms_user.dto.UserDto;
import com.aulamatriz.ms.management.ms_user.model.UserEntity;
import com.aulamatriz.ms.management.ms_user.repository.UserRepository;
import com.aulamatriz.ms.management.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> create(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto.getName(),
                                                  userDto.getEmail(),
                                                  userDto.getDocument(),
                                                  userDto.getTypeDocument());

        return ResponseEntity.ok(this.userRepository.save(userEntity));
    }

  /*  @Override
    public ResponseEntity<List<UserDto>> findAll() {

        System.out.println("findAll");

        List<UserEntity> usersList = this.userRepository.findAll();

        return ResponseEntity.ok(usersList.stream().map(this::mapDTO).toList());
    }*/

    @Override
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<?> userOptional = this.userRepository.findById(id);
        if(userOptional.isPresent()){
            this.userRepository.deleteById(id);
            return ResponseEntity.ok("User Deleted");
        }

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found");
    }


    private UserDto mapDTO(UserEntity user){

        System.out.println("userEntity:" + user.getId());
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setDocument(userDto.getDocument());
        userDto.setTypeDocument(userDto.getTypeDocument());

        return userDto;
    }
}
