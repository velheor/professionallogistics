package com.raccoontruck.startup.dto;

import com.raccoontruck.startup.models.ERole;

import java.util.List;

public class RoleDTO {
    private Integer id;

    private ERole name;

    private List<UserDTO> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}