package com.springbootbasiccrud.service;

import com.springbootbasiccrud.dto.UserDto;
import com.springbootbasiccrud.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    List<UserDto> getAll();
    UserDto getUser(Long id);
    UserDto updateUser(Long id, UserDto user);
    Boolean deleteUser(Long id);
}
