package com.velheor.internship.models;

import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trucks")
@Getter
@Setter
public class Truck extends BaseEntity {

    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "max_weight")
    private BigDecimal maxWeight;

    @Column(name = "truck_category")
    private ETruckCategory truckCategory;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "truck")
    private User user;

    @Override
    public String toString() {
        return "Truck(id=" + this.getId() + ", name=" + this.getName() + ", registrationNumber="
            + this.getRegistrationNumber() + ", maxWeight=" + this.getMaxWeight()
            + ", truckCategory= " + this.truckCategory + ")";
    }
}
