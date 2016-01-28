/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.service;

import com.maven.dealers.model.Country;
import java.util.List;

/**
 * Service Layer that is used by the controller for Country
 *
 * @author Amira
 */
public interface CountryService {

    /**
     * Function to list all countries
     *
     * @return List users objects
     */
    public List<Country> listCountries();

}
