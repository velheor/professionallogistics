package com.velheor.internship.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trucks", schema = "prolog")
@Getter
@Setter
@NoArgsConstructor
public class Truck extends BaseEntity {

    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "max_weight")
    private BigDecimal maxWeight;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "truck", orphanRemoval = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trucks_categories_id", referencedColumnName = "id")
    private TruckCategory truckCategory;

    @Override
    public String toString() {
        return "Truck(id=" + this.getId() + ", name=" + this.getName() + ", registrationNumber="
            + this.getRegistrationNumber() + ", maxWeight=" + this.getMaxWeight() + ")";
    }
}
