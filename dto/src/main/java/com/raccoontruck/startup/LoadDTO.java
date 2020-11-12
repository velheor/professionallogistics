package com.raccoontruck.startup;

import java.sql.Date;
import java.util.Set;

public class LoadDTO {
    private int id;

    private String cityTo;

    private String cityFrom;

    private Date dateTo;

    private Date dateFrom;

    private Date dateCheckIn;

    private Date dateCheckOut;

    private Long weight;

    private Long price;

    private String status;

    private UserDTO driverDTO;

    private UserDTO customerDTO;

    private Set<StatusDTO> statusDTO;

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

    public UserDTO getDriverDTO() {
        return driverDTO;
    }

    public void setDriverDTO(UserDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public UserDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(UserDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public Set<StatusDTO> getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(Set<StatusDTO> statusDTO) {
        this.statusDTO = statusDTO;
    }
}