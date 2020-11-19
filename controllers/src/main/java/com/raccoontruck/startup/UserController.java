package com.raccoontruck.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping
    public UserDTO delete(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO.getId());
        return userDTO;
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }
}