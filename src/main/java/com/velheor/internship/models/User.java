package com.velheor.internship.models;

import com.velheor.internship.models.enums.EUserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(name = "UserWithRoles",
        attributeNodes = {
                @NamedAttributeNode("roles")
        }
)
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private EUserStatus status = EUserStatus.INACTIVE;

    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL)
    private List<Order> carrierOrders;

    @OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
    private List<Order> shipperOrders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Session> sessions;

    public User(User user) {
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setPhoneNumber(user.getPhoneNumber());
        this.setPassword(user.getPassword());
        this.setStatus(user.getStatus());
    }

    @Override
    public String toString() {
        return "User(id=" + super.getId() + ", firstName=" + this.getFirstName() + ", lastName="
                + this.getLastName() + ", email=" + this.getEmail() + ", phoneNumber=" + this
                .getPhoneNumber() + ", password=" + this.getPassword() + ")";
    }
}
