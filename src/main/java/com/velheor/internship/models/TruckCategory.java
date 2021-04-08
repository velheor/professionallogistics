package com.velheor.internship.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trucks_categories", schema = "prolog")
public class TruckCategory {

    @Id
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private TruckCategory truckCategory;

    @ManyToMany(mappedBy = "truckCategories")
    private List<Order> orders;

    @OneToMany(mappedBy = "truckCategory")
    private List<Truck> trucks;

    public void addOrder(Order order) {
        this.orders.add(order);
        order.getTruckCategories().add(this);
    }

    public void deleteOrder(Order order) {
        this.orders.remove(order);
        order.getTruckCategories().remove(this);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TruckCategory other = (TruckCategory) obj;
        return Objects.equals(id, other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TruckCategory(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}
