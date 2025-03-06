package com.aulamatriz.ms.management.ms_user.controller.v1;

import com.aulamatriz.ms.management.ms_user.dto.UserDto;
import com.aulamatriz.ms.management.ms_user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final IUserService iUserService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
       return ResponseEntity.ok(this.iUserService.create(userDto));
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(this.iUserService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.iUserService.delete(id));
    }
}
