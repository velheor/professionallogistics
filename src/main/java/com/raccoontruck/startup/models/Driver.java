package com.raccoontruck.startup.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver extends User {
    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Truck truck;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<Load> loads;

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public List<Load> getLoads() {
        return loads;
    }

    public void setLoads(List<Load> loads) {
        this.loads = loads;
    }
}