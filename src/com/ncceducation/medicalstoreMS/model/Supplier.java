/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import com.ncceducation.medicalstoreMS.Controller.SupplierController;
import com.ncceducation.medicalstoreMS.Controller.UsersController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G50
 */
@Entity
@Table(name="supplier_detail")
public class Supplier {
    @Id @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;
    private String contact_no;
    private String email;
    private String address;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean saveSupplier() {
  SupplierController sc=new SupplierController();
  return (sc.saveSupplier(this));
    }

   
    public boolean updateSupplier() {
         SupplierController sc=new SupplierController();
  return (sc.updateSupplier(this));
    }

    public boolean deleteSupplier() {
       SupplierController sc=new SupplierController();
  return (sc.deleteSupplier(this));
    }

    public Supplier Search(int a) {
        SupplierController db = new SupplierController();
        return (db.Search(a));    }

    
     public ArrayList<Supplier>getAllValues()
    {
    SupplierController db=new SupplierController();
    return(db.getAllValues());
}

    public List<Supplier> ViewAllSuppliers() {
SupplierController csv=new SupplierController();
return(csv.viewAllSuppliers());    }
}
