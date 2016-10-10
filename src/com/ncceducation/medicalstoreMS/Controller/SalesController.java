/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import com.ncceducation.medicalstoreMS.model.Medicine;
import com.ncceducation.medicalstoreMS.model.Sales;
import com.ncceducation.medicalstoreMS.model.Supplier;
import com.ncceducation.medicalstoreMS.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author G50
 */
public class SalesController 
{
            private static SessionFactory factory;
public SalesController(){
      try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
}


 public boolean insertRecord(Sales sal) {
        Session session = this.openSession();
        Transaction tx = null;
        boolean result=false;
        try {
            tx = session.beginTransaction();
            
            session.save(sal);
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

    private SessionFactory getSession() {
     return new Configuration().configure().buildSessionFactory();//To change body of generated methods, choose Tools | Templates.
    }
         public Session openSession() {
        return factory.openSession();
    }
        public Session closeSession() {
        return this.closeSession();
        }
        
        public boolean updateSales(Sales u) {
        Session session = this.openSession();
        boolean ret=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Sales se = (Sales) session.get(Sales.class,u.getSales_id());
           session.update(se);

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

    public Sales Searchs(int u) {
        Session session=this.openSession();
        Transaction tx=null;
          Sales usr=new Sales();
        try
        {
           
            tx=session.beginTransaction();
     
             Sales se = (Sales) session.get(Sales.class,u);
            // Query qu=session.createQuery("from user_details where id=:u");
            Query query = session.createSQLQuery(
"select * from sales s where s.sales_id = :stockCode")
.addEntity(Sales.class)
.setParameter("stockCode", u);
List result = query.list();
            List user=query.list();
           
            
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Sales us = (Sales) iterator.next();
               usr.setSales_id(us.getSales_id());
                usr.setCustomer_name(us.getCustomer_name());
                        
                
                
      

               usr.setContact_no(us.getContact_no());
               usr.setMedicine_id(us.getMedicine_id());
               usr.setQuantity(us.getQuantity());
               
               usr.setTotal_price(us.getTotal_price());
               
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
return usr;    }

  
         public boolean DeleteSales(Sales u) {
        Session session = this.openSession();
        boolean con=false;
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            Sales se=(Sales) session.get(Sales.class,u.getSales_id());
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

    public List<Sales> viewAllSales() {
Session session=this.openSession();
        Transaction tx=null;
          Sales usr=new Sales();
          List <Sales>user=new ArrayList<>();
        try
        {
           
            tx=session.beginTransaction();
       
             
            Query query = session.createSQLQuery(
"select * from sales s where s.sales_id>0").addEntity(Sales.class);

List result = query.list();
            user=query.list();
           
              
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Sales us = (Sales) iterator.next();
               usr.setSales_id(us.getSales_id());
                usr.setMedicine_id(us.getMedicine_id());
                        
                
                
              

               usr.setCustomer_name((us.getCustomer_name()));
               usr.setQuantity(us.getQuantity());
               usr.setTotal_price(us.getTotal_price());
               
             
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
     
    return user;
}       }









