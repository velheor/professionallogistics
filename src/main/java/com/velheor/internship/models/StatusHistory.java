package com.velheor.internship.models;

import com.velheor.internship.models.enums.EStatusHistory;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "status_history", schema = "prolog")
public class StatusHistory {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private EStatusHistory name;

    private LocalDateTime statusDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
}
