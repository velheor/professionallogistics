package com.velheor.internship.models;

import javax.persistence.Basic;
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
import lombok.NonNull;

@Data
@Entity
@Table(name = "trucks", schema = "prolog")
public class Truck {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @NonNull
    @Basic
    @Column(name = "registration_number", nullable = false, length = 45)
    private String registrationNumber;

    @NonNull
    @Basic
    @Column(name = "max_weight", nullable = false)
    private Double maxWeight;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trucks_categories_id", referencedColumnName = "id")
    private TruckCategory truckCategory;
}
