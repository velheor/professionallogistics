package com.velheor.internship.models;

import com.velheor.internship.models.enums.ERole;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO need to change db for roles
@Data
@NoArgsConstructor
@Entity
@Table(name = "roles", schema = "prolog")
public class Role {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
