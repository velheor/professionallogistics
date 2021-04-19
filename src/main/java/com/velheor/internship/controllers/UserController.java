package com.velheor.internship.controllers;

import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserViewDTO findById(@PathVariable("id") UUID id) {
        return userMapper.userToUserDto(userService.findById(id));
    }

    @PutMapping
    public UserViewDTO update(@RequestBody UserViewDTO userViewDTO) {
        return userMapper.userToUserDto(userService.save(userMapper.userDtoToUser(userViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewDTO save(@RequestBody UserViewDTO userViewDTO) {
        return userMapper.userToUserDto(userService.save(userMapper.userDtoToUser(userViewDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        userService.deleteById(id);
    }
}
