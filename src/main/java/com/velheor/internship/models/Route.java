package com.velheor.internship.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Route extends BaseEntity {

    @Column(name = "address_to")
    private String addressTo;

    @Column(name = "address_from")
    private String addressFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    public Route(Route route) {
        super.setId(route.getId());
        this.setAddressTo(route.getAddressTo());
        this.setAddressFrom(route.getAddressFrom());
    }

    public String toString() {
        return "Route(addressTo=" + this.getAddressTo() + ", addressFrom=" + this.getAddressFrom()
            + ")";
    }
}
