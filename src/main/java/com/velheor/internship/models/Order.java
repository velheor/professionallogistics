package com.velheor.internship.models;

import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {

    @Column(name = "date_pickup")
    private LocalDateTime datePickup;

    @Column(name = "date_delivery")
    private LocalDateTime dateDelivery;

    private BigDecimal price;

    @Column(name = "voucher_pickup")
    private String voucherPickup;

    @Column(name = "voucher_delivery")
    private String voucherDelivery;

    @Enumerated(EnumType.STRING)
    @Column(name = "truck_category")
    private ETruckCategory truckCategory;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Route> routes;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Load> loads;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Status> statuses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id", referencedColumnName = "id")
    private User carrier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id", referencedColumnName = "id")
    private User shipper;

    public Order(Order order) {
        this.setId(order.getId());
        this.setDatePickup(order.getDatePickup());
        this.setDateDelivery(order.getDateDelivery());
        this.setPrice(order.getPrice());
        this.setVoucherPickup(order.getVoucherPickup());
        this.setVoucherDelivery(order.getVoucherDelivery());
        this.setTruckCategory(order.getTruckCategory());
        this.setShipper(new User(order.getShipper()));
    }

    public String toString() {
        return "Order(datePickup=" + this.getDatePickup() + ", dateDelivery=" + this
            .getDateDelivery() + ", price=" + this.getPrice() + ", voucherPickup=" + this
            .getVoucherPickup() + ", voucherDelivery=" + this.getVoucherDelivery()
            + ", truckCategory=" + this.getTruckCategory() + ")";
    }
}
