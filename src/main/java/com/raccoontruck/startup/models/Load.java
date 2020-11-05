package com.raccoontruck.startup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "loads")
public class Load {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_checkin")
    private Date dateCheckIn;

    @Column(name = "date_checkout")
    private Date dateCheckOut;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "price")
    private Long price;

    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        if (!Objects.equals(status, load.status)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cityTo != null ? cityTo.hashCode() : 0);
        result = 31 * result + (cityFrom != null ? cityFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateCheckIn != null ? dateCheckIn.hashCode() : 0);
        result = 31 * result + (dateCheckOut != null ? dateCheckOut.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
