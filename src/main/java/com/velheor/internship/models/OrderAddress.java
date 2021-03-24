package com.velheor.internship.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders_address", schema = "prolog")
public class OrderAddress {

    @Id
    @TableGenerator(
        name = "table_gen",
        table = "sequence_table",
        pkColumnName = "seq_name",
        valueColumnName = "seq_count",
        pkColumnValue = "order_address_seq"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
    private UUID id;

    private String addressTo;

    private String addressFrom;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    private Order order;
}
