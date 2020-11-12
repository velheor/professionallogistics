package com.raccoontruck.startup.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver extends User {
    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    private Truck truck;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<Load> loads;

    @Basic
    @Column(name = "count_of_finished_orders")
    private Integer countOfFinishedOrders;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private User user;

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

    public Integer getCountOfFinishedOrders() {
        return countOfFinishedOrders;
    }

    public void setCountOfFinishedOrders(Integer countOfFinishedOrders) {
        this.countOfFinishedOrders = countOfFinishedOrders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}