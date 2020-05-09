package com.startup.raccoontruck.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the city from")
    private String cityFrom;
    @NotBlank(message = "Please fill the city to")
    private String cityTo;
    @NotBlank(message = "Please fill the price")
    private String price;
    @NotBlank(message = "Please fill the weight")
    private String weight;

    private Long driverId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;


    private String filename;

    public Load() {
    }

    public Load(String cityFrom, String cityTo, String price, String weight, User customer, Long driverId) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean driverExists() {
        return driverId != null;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
