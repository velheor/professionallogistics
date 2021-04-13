package com.velheor.internship.models;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loads")
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

    public Load(Load load) {
        this.setId(load.getId());
        this.setName(load.getName());
        this.setWeight(load.getWeight());
        this.setDetails(load.getDetails());
        this.setOrder(new Order(load.getOrder()));
    }

    @Override
    public String toString() {
        return "Load(name=" + this.getName() + ", weight=" + this.getWeight() + ", details=" + this
            .getDetails() + ")";
    }
}
