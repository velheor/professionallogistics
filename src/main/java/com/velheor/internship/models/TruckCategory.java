package com.velheor.internship.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "trucks_categories", schema = "prolog")
public class TruckCategory {

    @Id
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private TruckCategory truckCategory;

    @ManyToMany(mappedBy = "truckCategories")
    private List<Load> load;

    @OneToMany(mappedBy = "truckCategory")
    private List<Truck> trucks;
}
