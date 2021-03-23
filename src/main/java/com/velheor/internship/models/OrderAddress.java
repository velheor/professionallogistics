package com.velheor.internship.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders_address", schema = "prolog")
public class OrderAddress {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "address_to", nullable = false, length = 45)
    private String addressTo;

    @Basic
    @Column(name = "address_from", nullable = false, length = 45)
    private String addressFrom;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    private Order order;
}
