package com.velheor.internship.models;

import com.velheor.internship.models.enums.ERole;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users", schema = "prolog")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany
    @JoinTable(
        name = "users_has_orders",
        joinColumns = @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Order> orders;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Truck truck;
}
