package com.raccoontruck.startup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @Column(name = "users_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_number")
    private Integer regNumber;

    @Column(name = "max_weight")
    private Double maxWeight;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Integer regNumber) {
        this.regNumber = regNumber;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        Truck truck = (Truck) o;
        return Objects.equals(getId(), truck.getId()) &&
                Objects.equals(getName(), truck.getName()) &&
                Objects.equals(getRegNumber(), truck.getRegNumber()) &&
                Objects.equals(getMaxWeight(), truck.getMaxWeight()) &&
                Objects.equals(getUser(), truck.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRegNumber(), getMaxWeight(), getUser());
    }
}