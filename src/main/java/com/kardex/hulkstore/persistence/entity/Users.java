package com.kardex.hulkstore.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "id")
    private String idUser;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchase;

    public String getIdCustomer() {
        return idUser;
    }

    public void setIdCustomer(String idCustomer) {
        this.idUser = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
