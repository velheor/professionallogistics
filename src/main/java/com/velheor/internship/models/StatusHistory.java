package com.velheor.internship.models;

import com.velheor.internship.models.enums.EStatusHistory;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "status_history", schema = "prolog")
public class StatusHistory {

    @Id
    @TableGenerator(
        name = "table_gen",
        table = "sequence_table",
        pkColumnName = "seq_name",
        valueColumnName = "seq_count",
        pkColumnValue = "status_history_seq"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private EStatusHistory name;

    private LocalDateTime statusDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    private Order order;
}
