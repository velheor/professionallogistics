package com.raccoontruck.startup.dto;

import java.util.List;

public class CustomerDTO extends UserDTO {

    private List<LoadDTO> loads;

    public List<LoadDTO> getLoads() {
        return loads;
    }

    public void setLoads(List<LoadDTO> loads) {
        this.loads = loads;
    }
}