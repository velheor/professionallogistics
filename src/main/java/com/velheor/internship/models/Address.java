package com.velheor.internship.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address extends BaseEntity {

    private String country;

    private String city;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    public Address(Address address) {
        this.setCountry(address.getCountry());
        this.setCity(address.getCity());
        this.setStreetName(address.getStreetName());
        this.setStreetNumber(address.getStreetNumber());
    }

    public String toString() {
        return "Address(country=" + this.getCountry() + ", city=" + this.getCity() + ", streetName="
                + this.getStreetName() + ", streetNumber=" + this.getStreetNumber() + ")";
    }
}
