package com.velheor.internship.models;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loads", schema = "prolog")
@Getter
@Setter
@NoArgsConstructor
public class Load extends BaseEntity {

    private String name;

    private BigDecimal weight;

    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    @ManyToMany
    @JoinTable(
        name = "loads_has_trucks_categories",
        joinColumns = @JoinColumn(name = "loads_id"),
        inverseJoinColumns = @JoinColumn(name = "trucks_categories_id"))
    private List<TruckCategory> truckCategories;

    @Override
    public String toString() {
        return "Load(name=" + this.getName() + ", weight=" + this.getWeight() + ", details=" + this
            .getDetails() + ")";
    }
}
