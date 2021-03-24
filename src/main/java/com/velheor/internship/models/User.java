package com.velheor.internship.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "prolog")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private Long phoneNumber;

    private String password;

    @ManyToMany
    @JoinTable(
        name = "users_has_orders",
        joinColumns = @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Order> orders;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Truck truck;

    @OneToMany(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private List<Role> role;
}
