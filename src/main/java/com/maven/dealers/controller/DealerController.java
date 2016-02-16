/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.controller;

import com.maven.dealers.model.Country;
import com.maven.dealers.model.Dealer;
import com.maven.dealers.service.CountryService;
import com.maven.dealers.service.DealerService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class of type controller that handles all logic related to mapping models to
 * presentation layer - all functions work directly with the service layer
 *
 * @author Amira
 */
@Controller
@RequestMapping("/admin")
public class DealerController {

    // initialize a new logger instance to log all operations related to this class
    private static final Logger logger = LoggerFactory.getLogger(DealerController.class);

    // declare a service instance to hanles operations in this controller
    private DealerService dealerService;

    // declare a service instance to hanles operations in this controller
    private CountryService countryService;

    /**
     * initialize the DealerService with a setter method and auto-wire it to the
     * service bean
     *
     * @param ds
     */
    @Autowired(required = true)
    @Qualifier("dealerService")
    public void setDealerService(DealerService ds) {
        this.dealerService = ds;
    }

    /**
     * initialize the CountryService with a setter method and auto-wire it to
     * the service bean
     *
     * @param cs
     */
    @Autowired(required = true)
    @Qualifier("countryService")
    public void setCountryService(CountryService cs) {
        this.countryService = cs;
    }

    /**
     * Function to list all Dealers and map their values with the view so they
     * can be accessed
     *
     * @param error messages after form processing if validation error exists
     * @return Dealers ModelAndView
     */
    @RequestMapping(value = {"/dailyNotes"}, method = {RequestMethod.GET})
    public ModelAndView listDealers(@RequestParam(required = false) String error) {
        logger.info(new Date() + " called controller function Requesting admin dealers view");
        List<Country> countryList = countryService.listCountries();
        ModelAndView mv = new ModelAndView("admin/dealers");
        mv.addObject("countryList", countryList);
        mv.addObject("dailyNote", new Dealer());
        mv.addObject("error", error);
        mv.addObject("listDealers", this.dealerService.listDealers());
        logger.info(new Date() + " returning ModelAndView with details" + mv.toString());
        logger.info("new code");
        return mv;
    }
        @RequestMapping(value = {"/test"}, method = {RequestMethod.GET})
    public ModelAndView test() {
        logger.info(new Date() + " called controller function Requesting admin dealers view");
        List<Country> countryList = countryService.listCountries();
        ModelAndView mv = new ModelAndView("angular");
        mv.addObject("error", "testing");

        logger.info(new Date() + " returning ModelAndView with details" + mv.toString());
        return mv;
    }

    /**
     * Function to add or update a dealer it's mapped with a model attribute
     * dealer
     *
     * @param d object of type Dealer
     * @param bindingResult for validation
     * @return Dealers ModelAndView
     *
     */
    @RequestMapping(value = {"/dailyNote/add"}, method = {RequestMethod.POST})
    public ModelAndView addDealer(@ModelAttribute("dailyNote") @Valid Dealer d, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("redirect:/admin/dealers");
        if (bindingResult.hasErrors()) {
            logger.error(new Date() + " Validation failed for adding a dealer value can't be null");
            mv.addObject("error", bindingResult.getFieldErrors().toString());
            return mv;
        }
        if (d.getId() == 0) {
            logger.debug(new Date() + " called controller function to add a dealer  = " + d);
            this.dealerService.addDealer(d);
        } else {
            logger.debug(new Date() + " called controller function to update a dealer = " + d);
            this.dealerService.updateDealer(d);
        }
        return mv;
    }

    /**
     * Function to delete a dealer by it's id it takes a path variable of type
     * Integer (id)
     *
     * @param id id of dealer to be deleted
     * @return Dealers ModelAndView
     *
     */
    @RequestMapping({"/removeDealer/{id}"})
    public ModelAndView removeDealer(@PathVariable("id") int id) {
        logger.info(new Date() + " called controller function to remove a dealer with id = " + id);
        this.dealerService.removeDealer(id);
        return new ModelAndView("redirect:/admin/dealers");
    }

    /**
     * Function to get a dealer by id to be updated
     *
     * @param id of the dealer to be updated
     * @return Dealers ModelAndView
     * @throws ObjectNotFoundException
     */
    @RequestMapping({"/editDealer/{id}"})
    public ModelAndView editDealer(@PathVariable("id") int id) throws ObjectNotFoundException {
        logger.info(new Date() + " called function to populate form for editing a dealer");
        Dealer dealer = this.dealerService.getDealerById(id);
        if (dealer == null) {
            logger.error(new Date() + " Exception happened while getting dealer with id = " + id);
            throw new ObjectNotFoundException(dealer, " Dealer with id : " + id + " Not Found");
        }
        logger.debug(new Date() + " Editing Dealer with id = " + id + " , Dealer = " + dealer);
        List<Country> countryList = countryService.listCountries();
        ModelAndView mv = new ModelAndView("admin/dealers");
        mv.addObject("countryList", countryList);
        mv.addObject("dealer", dealer);
        mv.addObject("listDealers", this.dealerService.listDealers());
        return mv;
    }

}
