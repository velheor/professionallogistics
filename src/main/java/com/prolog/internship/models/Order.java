package com.prolog.internship.models;

import java.sql.Date;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "date_to", nullable = false)
    private Date dateTo;

    @Basic
    @Column(name = "date_from", nullable = false)
    private Date dateFrom;

    @Basic
    @Column(name = "price", nullable = false)
    private Double price;

    @Basic
    @Column(name = "voucher", nullable = false, length = 45)
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
