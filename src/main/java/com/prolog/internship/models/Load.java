package com.prolog.internship.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "loads", schema = "prolog")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "weight", nullable = false)
    private Double weight;

    @Basic
    @Column(name = "details", nullable = false, length = 45)
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    private LoadCategory loadCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToMany
    @JoinTable(
            name = "trucks_categories_has_loads",
            joinColumns = @JoinColumn(name = "trucks_categories_id"),
            inverseJoinColumns = @JoinColumn(name = "loads_id"))
    private List<TruckCategory> truckCategories;
}
