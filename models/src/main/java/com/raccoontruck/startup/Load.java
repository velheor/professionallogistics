package com.raccoontruck.startup;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "loads")
public class Load {
    @Id
    @Basic
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "city_to")
    private String cityTo;

    @Basic
    @Column(name = "city_from")
    private String cityFrom;

    @Basic
    @Column(name = "date_to")
    private Date dateTo;

    @Basic
    @Column(name = "date_from")
    private Date dateFrom;

    @Basic
    @Column(name = "date_checkin")
    private Date dateCheckIn;

    @Basic
    @Column(name = "date_checkout")
    private Date dateCheckOut;

    @Basic
    @Column(name = "weight")
    private Double weight;

    @Basic
    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drivers_id", referencedColumnName = "id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "load")
    private Set<Status> status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Status> getStatus() {
        return status;
    }

    public void setStatus(Set<Status> status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Load load = (Load) o;

        if (id != load.id) return false;
        if (!Objects.equals(cityTo, load.cityTo)) return false;
        if (!Objects.equals(cityFrom, load.cityFrom)) return false;
        if (!Objects.equals(dateTo, load.dateTo)) return false;
        if (!Objects.equals(dateFrom, load.dateFrom)) return false;
        if (!Objects.equals(dateCheckIn, load.dateCheckIn)) return false;
        if (!Objects.equals(dateCheckOut, load.dateCheckOut)) return false;
        if (!Objects.equals(weight, load.weight)) return false;
        if (!Objects.equals(price, load.price)) return false;
        if (!Objects.equals(driver, load.driver)) return false;
        if (!Objects.equals(customer, load.customer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCityTo(), getCityTo(), getCityFrom(),
                getDateTo(), getDateFrom(), getDateCheckIn(),
                getDateCheckOut(), getWeight(), getPrice());
    }
}