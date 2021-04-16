package com.velheor.internship.controllers;

import com.velheor.internship.dto.UserDTO;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") UUID id) {
        return userMapper.userToUserDto(userService.findById(id));
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        userService.save(userMapper.userDtoToUser(userDTO));
        return userDTO;
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO) {
        userService.save(userMapper.userDtoToUser(userDTO));
        return userDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        userService.deleteById(id);
    }
}
