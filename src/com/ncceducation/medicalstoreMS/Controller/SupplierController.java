/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import com.ncceducation.medicalstoreMS.model.MedicineType;
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

    public Supplier Search(int a) {
        
    {
        Session session=this.openSession();
        Transaction tx=null;
          Supplier usr=new Supplier();
        try
        {
           
            tx=session.beginTransaction();
           // Query query = session.getNamedQuery("getbyid")
//.setString("stockCode", "1");
            
           // Query query=session.getNamedQuery("getbyid");
            //query.setParameter(0, 1);
             Supplier se = (Supplier) session.get(Supplier.class,a);
            // Query qu=session.createQuery("from user_details where id=:u");
            Query query = session.createSQLQuery(
"select * from supplier_detail s where s.id = :sid")
.addEntity(Supplier.class)
.setParameter("sid", a);
List result = query.list();
            List user=query.list();
           
            
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Supplier us = (Supplier) iterator.next();
               usr.setId(us.getId());
                usr.setFirst_name(us.getFirst_name());
                        System.out.println(us.getFirst_name());

               usr.setLast_name(us.getLast_name());
               usr.setContact_no(us.getContact_no());
               usr.setAddress(us.getAddress());
               usr.setEmail(us.getEmail());
               
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
        return usr;    
    }
    }

     public ArrayList<Supplier> getAllValues()
    {
        ArrayList<Supplier> result = new ArrayList();
        Session session=this.openSession();
        Transaction tx=null;
        Supplier md=new Supplier();
        try
        {
            tx=session.beginTransaction();
                 Query query = session.createSQLQuery(
"select * from supplier_detail")
.addEntity(Supplier.class);

          List user=query.list();

            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Supplier us = (Supplier) iterator.next();
                md.setFirst_name(us.getFirst_name());
                
                ;
                result.add(us);

            }
        }
        catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } finally {

        }
          return(result);   
    }
      

    

   
}
