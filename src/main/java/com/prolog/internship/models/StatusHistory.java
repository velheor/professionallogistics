package com.prolog.internship.models;

import com.prolog.internship.models.enums.ERole;
import com.prolog.internship.models.enums.EStatusHistory;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "status_history", schema = "prolog")
public class StatusHistory {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status_name", nullable = false, length = 45)
    private EStatusHistory name;

    @Basic
    @Column(name = "status_date", nullable = false)
    private Date statusDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    private Order order;
}
