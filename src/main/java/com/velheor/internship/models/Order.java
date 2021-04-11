package com.velheor.internship.models;

import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {

    @Column(name = "date_pickup")
    private LocalDateTime datePickup;

    @Column(name = "date_delivery")
    private LocalDateTime dateDelivery;

    private BigDecimal price;

    private String voucher;

    @Column(name = "truck_category")
    private ETruckCategory truckCategory;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Route> routes;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Load> loads;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Status> statusHistories;

    @ManyToMany(mappedBy = "orders")
    private List<User> users;

    public void addUser(User user) {
        this.users.add(user);
        user.getOrders().add(this);
    }

    public void deleteUser(User user) {
        this.users.remove(user);
        user.getOrders().remove(this);
    }

    @Override
    public String toString() {
        return "Order(id=" + this.getId() + ", datePickUp=" + this.getDatePickup()
            + ", dateDelivery=" + this
            .getDateDelivery() + ", price=" + this.getPrice() + ", voucher=" + this.getVoucher()
            +  ")";
    }
}
