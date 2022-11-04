package com.springbootbasiccrud.service.impl;

import com.springbootbasiccrud.dto.UserDto;
import com.springbootbasiccrud.entity.User;
import com.springbootbasiccrud.exception.UserNotNullException;
import com.springbootbasiccrud.repository.UserRepository;
import com.springbootbasiccrud.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        user.setCreatedTime(new Date());
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> dtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw new UserNotNullException("user is null");
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> userResult = userRepository.findById(id);
        if(userResult.isPresent()){
            userResult.get().setFirstName(user.getFirstName());
            userResult.get().setFamilyName(user.getFamilyName());
            return modelMapper.map(userRepository.save(userResult.get()),UserDto.class);
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
