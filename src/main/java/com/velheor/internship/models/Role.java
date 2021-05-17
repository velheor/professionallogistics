package com.velheor.internship.models;

import com.velheor.internship.models.enums.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    public Role(String role) {
        this.name = ERole.valueOf(role);
    }

    public Role(Role role) {
        this.setName(role.getName());
        this.setUser(new User(role.getUser()));
    }

    public String toString() {
        return "Role(name=" + this.getName() + ")";
    }
}
