package com.example.spaintask.models.userModel;

import com.example.spaintask.models.UserType;
import com.example.spaintask.models.serviceModel.Service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;



import javax.validation.constraints.Size;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class User {
    @Id
    private String serialNumber;

    @NotEmpty
    @Size(min = 2,message ="User name should have at least 2 characters" )
    @Field
    private String name;
    @NotEmpty
    @Size(min = 11, message = "Phone number should have 11 digit")
    @Field
    private String phone;

    @Field
    private UserType userType;

    @Size(max = 10)
    @Field
    private List<Service> service;

    @Size(min = 18)
    @Field
    private Integer age;

    public User() {}

    public User(String serialNumber, String name, String phone, UserType userType) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.phone = phone;
        this.userType = userType;
    }

    public User(String serialNumber, String name, String phone, List<Service> service) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.phone = phone;
        this.service = service;
    }

    public User(String serialNumber, String name, String phone, List<Service> service, UserType userType) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.phone = phone;
        this.service = service;
        this.userType = userType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
