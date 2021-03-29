package com.velheor.internship.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "loads", schema = "prolog")
public class Load {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private BigDecimal weight;

    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loads_categories_id", referencedColumnName = "id")
    private LoadCategory loadCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    @ManyToMany
    @JoinTable(
        name = "loads_has_trucks_categories",
        joinColumns = @JoinColumn(name = "loads_id"),
        inverseJoinColumns = @JoinColumn(name = "trucks_categories_id"))
    private List<TruckCategory> truckCategories;
}
