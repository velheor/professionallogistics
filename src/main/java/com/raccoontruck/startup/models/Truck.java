package com.raccoontruck.startup.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @Basic
    @Column(name = "drivers_id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "registration_number")
    private Integer regNumber;

    @Basic
    @Column(name = "max_weight")
    private Double maxWeight;

    @OneToOne
    @JoinColumn(name = "drivers_id", referencedColumnName = "id", nullable = false)
    private Driver driver;

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

    public User getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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
                Objects.equals(getDriver(), truck.getDriver());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRegNumber(), getMaxWeight(), getDriver());
    }
}