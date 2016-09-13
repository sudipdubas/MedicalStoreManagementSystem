/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import com.ncceducation.medicalstoreMS.model.User;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author G50
 */
public class Controller{
     private static SessionFactory factory;
        public Controller() {
        try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
    
    
     public int getMaxId()
    {
        Session session=this.openSession();
        Transaction tx=null;
        int value=0;
        try
        {
            tx=session.beginTransaction();
            String sql="Select max(id) from userdetail";
            SQLQuery query=session.createSQLQuery(sql);
            query.addEntity(User.class);
            List us=query.list();
             value=(Integer)us.get(0);
           
           
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } finally {
            
        }
            return value;
    } public boolean insertRecord(User user) {
        Session session = this.openSession();
        Transaction tx = null;
        boolean result=false;
        try {
            tx = session.beginTransaction();
            
            session.save(user);
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
     
     

 public SessionFactory getSession() {
        return new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        return factory.openSession();
    }
    
    
}