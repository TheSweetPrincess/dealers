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

/**
 * POJO Class for Country Table
 *
 * @author Amira
 */
@Entity
@Table(name = "Country")
public class Country implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "countryName")
    private String countryName;

    /**
     * Empty Constructor
     */
    public Country() {
    }

    /**
     * Constructor to initialize a Country
     *
     * @param countryName
     */
    public Country(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return id
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
     * @return countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return String for displaying country data for logging and debugging
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(" - Country Information: ");
        sb.append(" id ");
        sb.append(this.id);
        sb.append(", name ");
        sb.append(this.countryName);
        return sb.toString();
    }

}
