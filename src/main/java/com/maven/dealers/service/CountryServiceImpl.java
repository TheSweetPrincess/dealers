/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.service;

import com.maven.dealers.dao.CountryDAO;
import com.maven.dealers.model.Country;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Country Manipulation Service layer Implementation
 *
 * @author Amira
 */
@Service
public class CountryServiceImpl implements CountryService {

    // Logger to log all activities within this class
    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    //Declare a CountryDAO Object
    private CountryDAO countryDAO;

    /**
     * set value of the DAO object responsible for manipulating user data
     *
     * @param countryDAO
     */
    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    /**
     * Function to list all countries
     *
     * @return List countries objects
     */
    @Transactional
    @Override
    public List<Country> listCountries() {
        logger.info(new Date() + " Called Function listCountries");
        return this.countryDAO.listCountries();
    }

}
