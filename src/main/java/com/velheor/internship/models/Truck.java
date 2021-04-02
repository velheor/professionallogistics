package com.velheor.internship.models;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(name = "trucks", schema = "prolog")
public class Truck {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "max_weight")
    private BigDecimal maxWeight;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trucks_categories_id", referencedColumnName = "id")
    private TruckCategory truckCategory;
}
