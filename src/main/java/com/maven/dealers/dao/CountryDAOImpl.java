/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.dao;

import com.maven.dealers.model.Country;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Country Manipulation Data Access layer Implementation
 *
 * @author Amira
 */
@Repository
public class CountryDAOImpl implements CountryDAO {

    // Logger to log all activities within this class
    private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

    // Declare a sessionfactory object
    private SessionFactory sessionFactory;

    /**
     * Initialize a session factory for db operations
     *
     * @param sf
     */
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * Function to list all countries
     *
     * @return List countries objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Country> listCountries() {
        logger.info(new Date() + " called listCountries Function");
        Session session = this.sessionFactory.getCurrentSession();
        List<Country> countriesList = session.createQuery("from Country").list();
        for (Country c : countriesList) {
            logger.debug(new Date() + "Country List Data ::" + c);
        }
        return countriesList;
    }

}
