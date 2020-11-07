package com.raccoontruck.startup.dto;

import com.raccoontruck.startup.models.Load;

import java.util.List;

public class DriverDTO {
    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private TruckDTO truck;

    private List<LoadDTO> loads;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TruckDTO getTruck() {
        return truck;
    }

    public void setTruck(TruckDTO truck) {
        this.truck = truck;
    }

    public List<LoadDTO> getLoads() {
        return loads;
    }

    public void setLoads(List<LoadDTO> loads) {
        this.loads = loads;
    }
}
