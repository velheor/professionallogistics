package com.startup.raccoontruck.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the model")
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    private String model;
    @NotBlank(message = "Please fill the weight")
    @Length(max = 255, message = "Message too long (more than 255)")
    private Long maxWeight;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User driver;

    public Truck() {
    }

    public Truck(String model, Long maxWeight, User user) {
        this.driver = user;
        this.model = model;
        this.maxWeight = maxWeight;
    }

    public Long getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Long getMaxWeight() {
        return maxWeight;
    }

}