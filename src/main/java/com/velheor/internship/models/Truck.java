package com.velheor.internship.models;

import com.velheor.internship.models.enums.ETruckCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "trucks")
@Getter
@Setter
@NoArgsConstructor
public class Truck extends BaseEntity {

    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "max_weight")
    private BigDecimal maxWeight;

    @Enumerated(EnumType.STRING)
    @Column(name = "truck_category")
    private ETruckCategory truckCategory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    public Truck(Truck truck) {
        this.setId(truck.getId());
        this.setName(truck.getName());
        this.setRegistrationNumber(truck.getRegistrationNumber());
        this.setMaxWeight(truck.getMaxWeight());
        this.setTruckCategory(truck.getTruckCategory());
    }

    @Override
    public String toString() {
        return "Truck(id=" + this.getId() + ", name=" + this.getName() + ", registrationNumber="
                + this.getRegistrationNumber() + ", maxWeight=" + this.getMaxWeight()
                + ", truckCategory= " + this.truckCategory + ")";
    }
}
