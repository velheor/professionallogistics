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
@Table(name = "customers")
public class Customer extends User {
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Load> loads;

    @Basic
    @Column(name = "count_of_current_loads")
    private Integer countOfCurrentLoads;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private User user;

    public List<Load> getLoads() {
        return loads;
    }

    public void setLoads(List<Load> loads) {
        this.loads = loads;
    }

    public Integer getCountOfCurrentLoads() {
        return countOfCurrentLoads;
    }

    public void setCountOfCurrentLoads(Integer countOfCurrentLoads) {
        this.countOfCurrentLoads = countOfCurrentLoads;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}