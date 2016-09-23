/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import com.ncceducation.medicalstoreMS.Controller.MedicineController;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G50
 */
@Entity 
 @Table(name="medicine_type")
public class MedicineType {
    @Id @GeneratedValue
    private int type_id;
    private String typeName;
    private String Description;
   
    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public boolean save() {
        MedicineController mc=new MedicineController();
        return(mc.save(this));
        
    }

    /**
     * @return the type_id
     */
    public int getType_id() {
        return type_id;
    }

    /**
     * @param type_id the type_id to set
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    
    
   
    
    
    
}
