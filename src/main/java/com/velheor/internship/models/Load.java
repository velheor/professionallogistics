package com.velheor.internship.models;

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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loads", schema = "prolog")
public class Load {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private Double weight;

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
