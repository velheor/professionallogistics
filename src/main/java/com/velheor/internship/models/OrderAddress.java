package com.velheor.internship.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders_address", schema = "prolog")
public class OrderAddress {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "address_to")
    private String addressTo;

    @Column(name = "address_from")
    private String addressFrom;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
}
