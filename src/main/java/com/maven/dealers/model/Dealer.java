/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Amira
 */
@Entity
@Table(name = "dealers", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")})
public class Dealer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Length(min = 2, max = 20)
    private String name;

    @NotEmpty
    @Email(message = "Email not valid")
    private String email;

    private String phone;

    private String address;

    private String website;

    /**
     * Empty Constructor
     */
    public Dealer() {
    }

    /**
     * Constructor to initialize a dealer
     *
     * @param name
     * @param email
     * @param phone
     * @param address
     * @param website
     */
    public Dealer(String name, String email, String phone, String address, String website) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;

    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     * @return String for displaying dealer data for logging and debugging
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" - Dealer Information: ");
        sb.append(" id ");
        sb.append(this.id);
        sb.append(", name ");
        sb.append(this.name);
        sb.append(", email ");
        sb.append(this.email);
        sb.append(", phone ");
        sb.append(this.phone);
        sb.append(", address ");
        sb.append(this.address);
        sb.append(", website ");
        sb.append(this.website);
        return sb.toString();
    }

}
