package com.velheor.internship.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NamedEntityGraph(name = "SessionWithUser",
        attributeNodes = {
                @NamedAttributeNode("user")
        }
)
public class Session extends BaseEntity {

    private String ip;

    private String os;

    private String browser;

    @Column(name = "refresh_token")
    private String refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
}
