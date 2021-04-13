package com.velheor.internship.models;

import com.velheor.internship.models.enums.EStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statuses")
@Getter
@Setter
@NoArgsConstructor
public class Status extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EStatus name;

    @Column(name = "status_date")
    private LocalDateTime statusDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    public Status(Status status) {
        this.setId(status.getId());
        this.setName(status.getName());
        this.setStatusDate(status.getStatusDate());
        this.setOrder(new Order(status.getOrder()));
    }

    public String toString() {
        return "StatusHistory(name=" + this.getName() + ", statusDate=" + this.getStatusDate()
            + ")";
    }
}
