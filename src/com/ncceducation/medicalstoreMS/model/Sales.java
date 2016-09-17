/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import java.util.Date;

/**
 *
 * @author G50
 */
public class Sales {
    private int sales_id;
    private Customer customer_id;
    private Medicine medicine_id;
    private Date date;
    private int quantity;

    /**
     * @return the sales_id
     */
    public int getSales_id() {
        return sales_id;
    }

    /**
     * @param sales_id the sales_id to set
     */
    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    /**
     * @return the customer_id
     */
    public Customer getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the medicine_id
     */
    public Medicine getMedicine_id() {
        return medicine_id;
    }

    /**
     * @param medicine_id the medicine_id to set
     */
    public void setMedicine_id(Medicine medicine_id) {
        this.medicine_id = medicine_id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
