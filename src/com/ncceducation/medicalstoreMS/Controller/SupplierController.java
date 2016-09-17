/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import com.ncceducation.medicalstoreMS.model.Supplier;
import com.ncceducation.medicalstoreMS.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author G50
 */
public class SupplierController {
     private static SessionFactory factory;
        public SupplierController() {
        try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private SessionFactory getSession() {
     return new Configuration().configure().buildSessionFactory();//To change body of generated methods, choose Tools | Templates.
    }
      public Session openSession() {
        return factory.openSession();
    }

    public Session closeSession() {
        return this.closeSession();
    }

    public boolean saveSupplier(Supplier sup) {
         Session session = this.openSession();
        Transaction tx = null;
        boolean result=false;
        try {
            tx = session.beginTransaction();
            
            session.save(sup);
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
        return result;      
    }

    public boolean updateSupplier(Supplier u) {
           Session session = this.openSession();
        boolean ret=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Supplier se = (Supplier) session.get(Supplier.class,u.getId());
           se.setFirst_name(u.getFirst_name());
           se.setLast_name(u.getLast_name());
           se.setAddress(u.getAddress());
           se.setContact_no(u.getContact_no());
           se.setEmail(u.getEmail());
        
           //session.update(u);
           ret=true;         
           tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ret=false;
            }
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
        return ret;
    }

    public boolean deleteSupplier(Supplier u) {
     
        Session session = this.openSession();
        boolean con=false;
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            Supplier se=(Supplier) session.get(Supplier.class,u.getId());
            session.delete(se);
            tx.commit();
            con=true;

        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                con=false;
            }
            System.out.println(ex.getMessage());
        } finally {
            
        }
        return con;
    }
    

   
}
