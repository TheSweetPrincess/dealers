/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.dao;

import com.maven.dealers.model.Dealer;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * User Manipulation Data Access layer Implementation
 *
 * @author Amira
 */
@Repository
public class DealerDAOImpl implements DealerDAO {

    // Logger to log all activities within this class
    private static final Logger logger = LoggerFactory.getLogger(DealerDAOImpl.class);

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
     * Function to add a Dealer
     *
     * @param d
     */
    @Override
    public void addDealer(Dealer d) {
        logger.info(new Date() + " Called Function addDealer");
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(d);
        logger.debug(new Date() + " User saved successfully, Dealer Details=" + d);
    }

    /**
     * Function to update a Dealer
     *
     * @param d
     */
    @Override
    public void updateDealer(Dealer d) {
        logger.info(new Date() + " Called Function updateDealer");
        Session session = this.sessionFactory.getCurrentSession();
        session.update(d);
        logger.debug(new Date() + " User updated successfully, Dealer Details=" + d);
    }

    /**
     * Function to list all dealers
     *
     * @return List dealers objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Dealer> listDealers() {
        logger.info(new Date() + " Called Function listDealers");
        Session session = this.sessionFactory.getCurrentSession();
        List<Dealer> dealersList = session.createQuery("from Dealer").list();
        for (Dealer d : dealersList) {
            logger.debug(new Date() + " Dealer List Data::" + d);
        }
        return dealersList;
    }

    /**
     * Function to find a dealer by id
     *
     * @param id dealer id
     * @return dealer object
     */
    @Override
    public Dealer getDealerById(int id) {
        logger.info(new Date() + " Called Function getDealerById with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        Dealer d = (Dealer) session.load(Dealer.class, new Integer(id));
        logger.debug(new Date() + " Dealer loaded successfully, Dealer details=" + d);
        return d;
    }

    /**
     * Function to delete a dealer by id
     *
     * @param id dealer id
     */
    @Override
    public void removeDealer(int id) {
        logger.info(new Date() + " Called Function removeDealer with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        Dealer d = (Dealer) session.load(Dealer.class, new Integer(id));
        if (null != d) {
            session.delete(d);
        }
        logger.debug(new Date() + " Dealer deleted successfully, Dealer details=" + d);
    }

}
