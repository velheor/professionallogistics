package com.velheor.internship.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "date_to")
    private LocalDateTime dateTo;

    @Column(name = "date_from")
    private LocalDateTime dateFrom;

    private BigDecimal price;

    private String voucher;

    @OneToMany(mappedBy = "order")
    private List<OrderAddress> orderAddress;

    @OneToMany(mappedBy = "order")
    private List<Load> loads;

    @OneToMany(mappedBy = "order")
    private List<StatusHistory> statusHistories;

    @ManyToMany(mappedBy = "orders")
    private List<User> user;

    @Override
    public String toString() {
        return "Order(id=" + this.getId() + ", dateTo=" + this.getDateTo() + ", dateFrom=" + this
            .getDateFrom() + ", price=" + this.getPrice() + ", voucher=" + this.getVoucher()
            + ")";
    }
}
