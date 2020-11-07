package com.raccoontruck.startup.dto;

import com.raccoontruck.startup.models.EStatus;

import java.sql.Date;

public class StatusDTO {
    private Integer id;

    private EStatus name;

    private Date date;

    private LoadDTO load;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EStatus getName() {
        return name;
    }

    public void setName(EStatus name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LoadDTO getLoad() {
        return load;
    }

    public void setLoad(LoadDTO load) {
        this.load = load;
    }
}