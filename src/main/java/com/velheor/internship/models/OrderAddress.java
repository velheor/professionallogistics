package com.velheor.internship.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders_address")
@Getter
@Setter
@NoArgsConstructor
public class OrderAddress extends BaseEntity {

    @Column(name = "address_to")
    private String addressTo;

    @Column(name = "address_from")
    private String addressFrom;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
}
