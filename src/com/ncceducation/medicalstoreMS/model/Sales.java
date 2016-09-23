/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import com.ncceducation.medicalstoreMS.Controller.MedicineController;
import com.ncceducation.medicalstoreMS.Controller.SalesController;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G50
 */
@Entity
@Table(name="sales")
public class Sales {
    @Id @GeneratedValue
    private int sales_id;
    private String customer_name;
    private String medicine_id;
   private String contact_no;
    private int quantity;
    private int total_price;

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
     * @return the medicine_id
     */
    public String getMedicine_id() {
        return medicine_id;
    }

    /**
     * @param medicine_id the medicine_id to set
     */
    public void setMedicine_id(String medicine_id) {
        this.medicine_id = medicine_id;
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

    /**
     * @return the total_price
     */
    public int getTotal_price() {
        return total_price;
    }

    /**
     * @param total_price the total_price to set
     */
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

     public boolean save(){
        SalesController c1=new SalesController();
        return(c1.insertRecord(this));
    }
    
        public boolean updateSales() {
SalesController d=new SalesController();
              return(d.updateSales(this));    }

 

    public Sales Searchs(int a) {
 SalesController db = new SalesController();
        return (db.Searchs(a));     }


   public boolean DeleteUser(){
            SalesController d=new SalesController();
   return( d.DeleteSales(this));
}    


}
