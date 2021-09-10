package com.velheor.internship.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

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
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
        name = "CostWithOrder",
        attributeNodes = {
                @NamedAttributeNode(value = "order", subgraph = "OrderWithUsers"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "OrderWithUsers",
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
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "currency_name")
    private String currencyName;

    private BigDecimal amount;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;
}
