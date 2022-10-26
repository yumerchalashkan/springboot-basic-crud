package com.springbootbasiccrud.controller;

import com.springbootbasiccrud.dto.UserDto;
import com.springbootbasiccrud.entity.User;
import com.springbootbasiccrud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
        UserDto result = userService.getUser(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user){
        UserDto result = userService.updateUser(id, user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }
}
