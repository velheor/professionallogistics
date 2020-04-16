package com.startup.raccoontruck.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the city from")
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    private String cityFrom;
    @NotBlank(message = "Please fill the city to")
    @Length(max = 2048, message = "Message too long (more than 255)")
    private String cityTo;
    @NotBlank(message = "Please fill the price")
    private Long price;
    @NotBlank(message = "Please fill the weight")
    private Long weight;

    private Long driverId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;


    public Trip() {
    }

    public Trip(String cityFrom, String cityTo, Long price, Long weight, User customer, Long driverId) {
        this.customer = customer;
        this.driverId = driverId;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.price = price;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Long getDriver() {
        return driverId;
    }

    public void setDriver(Long driver) {
        this.driverId = driver;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
