/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import com.ncceducation.medicalstoreMS.Controller.CustomerController;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G50
 */
@Entity
@Table(name="customer")
public class Customer {
    @Id @GeneratedValue
    private int customer_id;
    private String customer_name;
    private String contact_no;

    /**
     * @return the customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /**
     * @param customer_name the customer_name to set
     */
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    /**
     * @return the contact_no
     */
    public String getContact_no() {
        return contact_no;
    }

    /**
     * @param contact_no the contact_no to set
     */
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public boolean saveCustomer() {
CustomerController cc=new CustomerController();
return(cc.saveCustomer(this));
    }
    
}
