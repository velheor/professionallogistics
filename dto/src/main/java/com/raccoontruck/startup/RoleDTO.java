package com.raccoontruck.startup;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class RoleDTO {
    private Integer id;

    private ERole name;

    @JsonIgnore
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