package com.velheor.internship.models;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "trucks", schema = "prolog")
@Getter
@Setter
@NoArgsConstructor
public class Truck {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "max_weight")
    private BigDecimal maxWeight;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trucks_categories_id", referencedColumnName = "id")
    private TruckCategory truckCategory;

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Truck other = (Truck) obj;
        return Objects.equals(id, other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Truck(id=" + this.getId() + ", name=" + this.getName() + ", registrationNumber="
            + this.getRegistrationNumber() + ", maxWeight=" + this.getMaxWeight() + ")";
    }
}
