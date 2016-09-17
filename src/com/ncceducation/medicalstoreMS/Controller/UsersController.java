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
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author G50
 */
public final class UsersController{
     private static SessionFactory factory;
        public UsersController() {
        try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
    
    //This method retrievers maximum id from database and returns to the form page
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
    } 
     //THis functions receives details of user and Saves it to database
     public boolean insertRecord(User user) {
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
//This functions takes id from user and Search value from the database of this id and returns all the values
    public User Search(int u)
    {
        Session session=this.openSession();
        Transaction tx=null;
          User usr=new User();
        try
        {
           
            tx=session.beginTransaction();
           // Query query = session.getNamedQuery("getbyid")
//.setString("stockCode", "1");
            
           // Query query=session.getNamedQuery("getbyid");
            //query.setParameter(0, 1);
             User se = (User) session.get(User.class,u);
             Query qu=session.createQuery("from user_details where id=u");
            List user=qu.list();
           
            
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                User us = (User) iterator.next();
               
                usr.setFirst_name(us.getFirst_name());
               usr.setLast_name(us.getLast_name());
               usr.setContact_no(us.getContact_no());
               usr.setAddress(us.getAddress());
               usr.setUsername(us.getUsername());
               usr.setPassword(us.getPassword());
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
        return usr;    
    }
    //This functions takes user id and deletes information from the database
        public boolean DeleteUser(User u) {
        Session session = this.openSession();
        boolean con=false;
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            User se=(User) session.get(User.class,u.getId());
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
             
             //This functions updates the value of particular user into database
               public boolean updateUser(User u) {
        Session session = this.openSession();
        boolean ret=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User se = (User) session.get(User.class,u.getId());
           se.setFirst_name(u.getFirst_name());
           se.setLast_name(u.getLast_name());
           se.setAddress(u.getAddress());
           se.setContact_no(u.getContact_no());
           se.setUsername(u.getUsername());
           se.setPassword(u.getPassword());
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
     
     

 public SessionFactory getSession() {
        return new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        return factory.openSession();
    }
    
       public Session closeSession() {
        return this.closeSession();
    }
}