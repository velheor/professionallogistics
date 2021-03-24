package com.velheor.internship.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.UUID;
import javax.persistence.SequenceGenerator;

import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loads", schema = "prolog")
public class Load {

    @Id
    @TableGenerator(
            name = "table_gen",
            table = "sequence_table",
            pkColumnName = "seq_name",
            valueColumnName = "seq_count",
            pkColumnValue = "load_seq"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
    private UUID id;

    private String name;

    private Double weight;

    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    private LoadCategory loadCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToMany
    @JoinTable(
            name = "trucks_categories_has_loads",
            joinColumns = @JoinColumn(name = "trucks_categories_id"),
            inverseJoinColumns = @JoinColumn(name = "loads_id"))
    private List<TruckCategory> truckCategories;
}
