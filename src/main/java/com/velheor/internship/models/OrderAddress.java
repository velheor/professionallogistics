package com.velheor.internship.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders_address", schema = "prolog")
public class OrderAddress {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String addressTo;

    private String addressFrom;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
}
