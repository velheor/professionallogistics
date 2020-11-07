package com.raccoontruck.startup.service.impl;

import com.raccoontruck.startup.dto.UserDTO;
import com.raccoontruck.startup.models.User;
import com.raccoontruck.startup.repository.api.UserRepository;
import com.raccoontruck.startup.service.api.IUserService;
import com.raccoontruck.startup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return convertToDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDTO convertToDTO(User User) {
        return ObjectMapperUtils.map(User, UserDTO.class);
    }

    @Override
    public User convertFromDTO(UserDTO UserDTO) {
        return ObjectMapperUtils.map(UserDTO, User.class);
    }

    @Override
    public List<UserDTO> convertToDTO(List<User> Users) {
        return ObjectMapperUtils.mapAll(Users, UserDTO.class);
    }

    @Override
    public List<User> convertFromDTO(List<UserDTO> UserDTOS) {
        return ObjectMapperUtils.mapAll(UserDTOS, User.class);
    }
}