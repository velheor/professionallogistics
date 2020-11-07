package com.raccoontruck.startup.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends User {
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Load> loads;

    public List<Load> getLoads() {
        return loads;
    }

    public void setLoads(List<Load> loads) {
        this.loads = loads;
    }
}