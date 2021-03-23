package com.prolog.internship.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles", schema = "prolog")
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "role_name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
