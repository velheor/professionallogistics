package com.velheor.internship.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders", schema = "prolog")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {

    @Column(name = "date_pickup")
    private LocalDateTime datePickup;

    @Column(name = "date_delivery")
    private LocalDateTime dateDelivery;

    private BigDecimal price;

    private String voucher;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderAddress> orderAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Load> loads;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<StatusHistory> statusHistories;

    @ManyToMany(mappedBy = "orders")
    private List<User> users;

    @ManyToMany
    @JoinTable(
        schema = "prolog",
        name = "orders_has_trucks_categories",
        joinColumns = @JoinColumn(name = "orders_id"),
        inverseJoinColumns = @JoinColumn(name = "trucks_categories_id"))
    private Set<TruckCategory> truckCategories;

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
            + ")";
    }
}
