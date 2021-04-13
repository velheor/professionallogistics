package com.velheor.internship.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL)
    private List<Order> carrierOrders;

    @OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
    private List<Order> shipperOrders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Truck truck;

    public User(User user) {
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setPhoneNumber(user.getPhoneNumber());
        this.setPassword(user.getPassword());
    }

    @Override
    public String toString() {
        return "User(id=" + super.getId() + ", firstName=" + this.getFirstName() + ", lastName="
            + this.getLastName() + ", email=" + this.getEmail() + ", phoneNumber=" + this
            .getPhoneNumber() + ", password=" + this.getPassword() + ")";
    }
}
