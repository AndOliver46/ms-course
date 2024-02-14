package com.andoliver46.ms.userservice.controllers;

import com.andoliver46.ms.userservice.dtos.UserRecordDTO;
import com.andoliver46.ms.userservice.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDTO,userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }
}
