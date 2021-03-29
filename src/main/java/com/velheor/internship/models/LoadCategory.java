package com.velheor.internship.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "loads_categories", schema = "prolog")
public class LoadCategory {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "loadCategory")
    private List<Load> loads;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private LoadCategory loadCategory;
}
