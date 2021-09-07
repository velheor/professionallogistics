package com.velheor.internship.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "costs")
@Data
@EqualsAndHashCode
@NamedEntityGraph(
        name = "CostWithOrder",
        attributeNodes = {
                @NamedAttributeNode(value = "order", subgraph = "orderWithUsers"),
        },
        subgraphs = {
                @NamedSubgraph(name = "orderWithUsers",
                        attributeNodes = {
                                @NamedAttributeNode(value = "carrier"),
                                @NamedAttributeNode(value = "shipper")
                        }
                )
        }
)
public class Cost {

    @Id
    @Column(name = "order_id")
    private UUID id;

    @Column(name = "currency_name")
    private String currencyName;

    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    private Order order;

    public void updateAmountAndCurrency(String currencyName, BigDecimal amount) {
        this.currencyName = currencyName;
        this.amount = amount;
    }
}
