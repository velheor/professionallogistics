package com.velheor.internship.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders", schema = "prolog")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private LocalDateTime dateTo;

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
}
