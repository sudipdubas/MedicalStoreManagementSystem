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
public class Medicine {
    private int id;
    private String medicine_name;
    private MedicineType medicine_Type;
    private Supplier supplier_name;
    private Date manufature_date;
    private Date expire_date;
    private double price;
    private int quantity;
    private String Description;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the medicine_name
     */
    public String getMedicine_name() {
        return medicine_name;
    }

    /**
     * @param medicine_name the medicine_name to set
     */
    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    /**
     * @return the medicine_Type
     */
    public MedicineType getMedicine_Type() {
        return medicine_Type;
    }

    /**
     * @param medicine_Type the medicine_Type to set
     */
    public void setMedicine_Type(MedicineType medicine_Type) {
        this.medicine_Type = medicine_Type;
    }

    /**
     * @return the supplier_name
     */
    public Supplier getSupplier_name() {
        return supplier_name;
    }

    /**
     * @param supplier_name the supplier_name to set
     */
    public void setSupplier_name(Supplier supplier_name) {
        this.supplier_name = supplier_name;
    }

    /**
     * @return the manufature_date
     */
    public Date getManufature_date() {
        return manufature_date;
    }

    /**
     * @param manufature_date the manufature_date to set
     */
    public void setManufature_date(Date manufature_date) {
        this.manufature_date = manufature_date;
    }

    /**
     * @return the expire_date
     */
    public Date getExpire_date() {
        return expire_date;
    }

    /**
     * @param expire_date the expire_date to set
     */
    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
        
    
    
}
