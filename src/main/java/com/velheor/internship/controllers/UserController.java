package com.velheor.internship.controllers;

import com.velheor.internship.dto.UserProfileUpdateDTO;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.models.User;
import com.velheor.internship.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"user crud controller"})
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find user by id")
    public UserViewDTO findById(@PathVariable("id") UUID id) {
        return userMapper.toUserViewDto(userService.findById(id));
    }

    @GetMapping
    @ApiOperation(value = "Get all users")
    public Iterable<UserViewDTO> getAll() {
        return userMapper.toUserViewDto(userService.getAll());
    }

    @PutMapping
    @ApiOperation(value = "Update user by user view dto")
    public UserViewDTO update(@Valid @RequestBody UserViewDTO userViewDTO) {
        return userMapper.toUserViewDto(userService.save(userMapper.userDtoToUser(userViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save user by user view dto")
    public UserViewDTO save(@Valid @RequestBody UserViewDTO userViewDTO) {
        return userMapper.toUserViewDto(userService.save(userMapper.userDtoToUser(userViewDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "delete user by id")
    public void deleteById(@PathVariable("id") UUID id) {
        userService.deleteById(id);
    }

    @PutMapping("/profile")
    public UserProfileUpdateDTO updateProfile(Principal principal, @Valid @RequestBody UserProfileUpdateDTO userProfileUpdateDTO) {
        User user = userMapper.toUser(userProfileUpdateDTO);
        return userMapper.toUserProfileDto(userService.updateCurrentUser(principal.getName(), user));
    }
}
