package com.velheor.internship.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders", schema = "prolog")
public class Order {

    @Id
    @TableGenerator(
        name = "table_gen",
        table = "sequence_table",
        pkColumnName = "seq_name",
        valueColumnName = "seq_count",
        pkColumnValue = "order_seq"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
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
