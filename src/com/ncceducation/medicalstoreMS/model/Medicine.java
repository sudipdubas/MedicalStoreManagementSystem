/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import com.ncceducation.medicalstoreMS.Controller.MedicineController;
import com.ncceducation.medicalstoreMS.Controller.SupplierController;
import com.ncceducation.medicalstoreMS.Controller.UsersController;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author G50
 */
@Entity
@Table(name="medicine")
public class Medicine {
    @Id @GeneratedValue
    private int id;
    private String medicine_name;
    
   // @OneToOne(cascade=CascadeType.ALL)
    
   // @JoinColumn(name="type_id")
    
    private String medicine_Type;
     //  @OneToOne(cascade=CascadeType.ALL)
    
    //@JoinColumn(name="id")
    private String supplier_name;
    private String manufature_date;
    private String expire_date;
    private int price;
    private int quantity;
    private String Description;

    /**
     * @return the id
     */
   


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
        
    public ArrayList<MedicineType>getAllValues()
{
    MedicineController db=new MedicineController();
    return(db.getAllValues());
}

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
     * @param medicine_Type the medicine_Type to set
     */
    public void setMedicine_Type(String medicine_Type) {
        this.medicine_Type = medicine_Type;
    }

    /**
     * @param supplier_name the supplier_name to set
     */
    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    /**
     * @return the medicine_Type
     */
    public String getMedicine_Type() {
        return medicine_Type;
    }

    /**
     * @return the supplier_name
     */
    public String getSupplier_name() {
        return supplier_name;
    }

    /**
     * @param manufature_date the manufature_date to set
     */
    public void setManufature_date(String manufature_date) {
        this.manufature_date = manufature_date;
    }

    /**
     * @param expire_date the expire_date to set
     */
    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }
     public boolean save(){
        MedicineController c1=new MedicineController();
        return(c1.insertRecord(this));
    }
     public Medicine Search(int a) {
        MedicineController db = new MedicineController();
        return (db.Search(a));    }
     
     public boolean DeleteUser(){
            MedicineController d=new MedicineController();
   return( d.DeleteUser(this));
}

    public boolean updateMedicine() {
MedicineController d=new MedicineController();
              return(d.updateMedicine(this));    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
     public ArrayList<Medicine>getValues()
{
    MedicineController db=new MedicineController();
    return(db.getValues());
}
}