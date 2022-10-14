package com.example.spaintask.models.serviceModel;

import com.example.spaintask.models.Status;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;



@Document
public class Service {

    @Id
    private Integer id;
    private String vendor;
    private Status status;

    private boolean isActive = false;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Field
    private Date date;

    public Service() {}

    public Service(Integer id, String vendor, Status status, boolean isActive, Date date) {
        this.id = id;
        this.vendor = vendor;
        this.status = status;
        this.isActive = isActive;
        this.date = date;
    }

    public Service(Integer id, String vendor, boolean isActive, Date date) {
        this.id = id;
        this.vendor = vendor;
        this.isActive = isActive;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsActive() {
        return isActive;
    }
}
