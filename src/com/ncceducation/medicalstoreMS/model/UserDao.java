/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

/**
 *
 * @author G50
 */
public class UserDao {
    
    private static SessionFactory factory;
       public UserDao() {
        try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private SessionFactory getSession() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
