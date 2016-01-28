/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.service;

import com.maven.dealers.dao.DealerDAO;
import com.maven.dealers.model.Dealer;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dealer Manipulation Service layer Implementation
 *
 * @author Amira
 */
@Service
public class DealerServiceImpl implements DealerService {

    // Logger to log all activities within this class
    private static final Logger logger = LoggerFactory.getLogger(DealerServiceImpl.class);

    //Declare a DealerDAO Object
    private DealerDAO dealerDAO;

    /**
     * set value of the DAO object responsible for manipulating dealer data
     *
     * @param dealerDAO
     */
    public void setDealerDAO(DealerDAO dealerDAO) {
        this.dealerDAO = dealerDAO;
    }

    /**
     * Function to add a dealer
     *
     * @param d Dealer object
     */
    @Transactional
    @Override
    public void addDealer(Dealer d) {
        logger.info(new Date() + " Called Function addDealer with Dealer = " + d);
        this.dealerDAO.addDealer(d);
    }

    /**
     * Function to update a dealer
     *
     * @param d Dealer object
     */
    @Transactional
    @Override
    public void updateDealer(Dealer d) {
        logger.info(new Date() + " Called Function updateDealer with Dealer = " + d);
        this.dealerDAO.updateDealer(d);
    }

    /**
     * Function to list all dealers
     *
     * @return List dealers objects
     */
    @Transactional
    @Override
    public List<Dealer> listDealers() {
        logger.info(new Date() + " Called Function listDealers");
        return this.dealerDAO.listDealers();
    }

    /**
     * Function to find a dealer by id
     *
     * @param id dealer id
     * @return Dealer object
     */
    @Transactional
    @Override
    public Dealer getDealerById(int id) {
        logger.info(new Date() + " Called Function getDealerById with id = " + id);
        return this.dealerDAO.getDealerById(id);
    }

    /**
     * Function to delete a dealer by id
     *
     * @param id dealer id
     */
    @Transactional
    @Override
    public void removeDealer(int id) {
        logger.info(new Date() + " Called Function removeDealer with id = " + id);
        this.dealerDAO.removeDealer(id);
    }

}
