/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import com.ncceducation.medicalstoreMS.model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author G50
 */
public class CustomerController {
    private static SessionFactory factory;
public CustomerController(){
      try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
}

    private SessionFactory getSession() {
     return new Configuration().configure().buildSessionFactory();//To change body of generated methods, choose Tools | Templates.
    }

    public boolean saveCustomer(Customer cr) {
        Session session = this.openSession();
        Transaction tx = null;
        boolean result=false;
        try {
            tx = session.beginTransaction();
            
            session.save(cr);
            tx.commit();
            result=true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return result;     }
    
      public Session openSession() {
        return factory.openSession();
    }
        public Session closeSession() {
        return this.closeSession();
    }
    
}
