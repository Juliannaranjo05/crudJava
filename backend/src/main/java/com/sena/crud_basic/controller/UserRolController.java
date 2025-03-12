package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;

import com.sena.crud_basic.DTO.UserRolDTO;
import com.sena.crud_basic.service.UserRolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/userRol")
public class UserRolController {

    @Autowired
    private UserRolService userRolService;

    @PostMapping("/")
    public ResponseEntity<Object> registerUserRol(@RequestBody UserRolDTO userRol) {
        userRolService.save(userRol);
        return new ResponseEntity<>("UserRol registrado correctamente", HttpStatus.OK);
    }
}