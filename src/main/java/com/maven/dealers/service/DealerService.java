/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.service;

import com.maven.dealers.model.Dealer;
import java.util.List;

/**
 * Service Layer that is used by the controller for Dealer
 *
 * @author Amira
 */
public interface DealerService {

    /**
     * Function to add a dealer
     *
     * @param d
     */
    public void addDealer(Dealer d);

    /**
     * Function to update a dealer
     *
     * @param d
     */
    public void updateDealer(Dealer d);

    /**
     * Function to list all dealers
     *
     * @return List dealers objects
     */
    public List<Dealer> listDealers();

    /**
     * Function to find a dealer by id
     *
     * @param id dealer id
     * @return dealer object
     */
    public Dealer getDealerById(int id);

    /**
     * Function to delete a dealer by id
     *
     * @param id dealer id
     */
    public void removeDealer(int id);
}
