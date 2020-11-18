package com.raccoontruck.startup;

import java.util.List;

public class DriverDTO extends UserDTO {
    private TruckDTO truck;

    private List<LoadDTO> loads;

    private UserDTO userDTO;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}