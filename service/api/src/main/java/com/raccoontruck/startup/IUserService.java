package com.raccoontruck.startup;

public interface IUserService extends IGenericService<UserDTO, User> {
    UserDTO findByEmail(String email);
}