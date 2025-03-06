package com.aulamatriz.ms.management.ms_user.controller.v2;

import com.aulamatriz.ms.management.ms_user.controller.v2.docs.IUserDoc;
import com.aulamatriz.ms.management.ms_user.dto.UserDto;
import com.aulamatriz.ms.management.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v2/users")
public class UserControllerV2 implements IUserDoc {

    private final IUserService userService;

    @Override
    public ResponseEntity<?> create(UserDto userDto) {
        return this.userService.create(userDto);

    }
}
