/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import com.ncceducation.medicalstoreMS.model.Medicine;
import com.ncceducation.medicalstoreMS.model.MedicineType;
import com.ncceducation.medicalstoreMS.model.Sales;
import com.ncceducation.medicalstoreMS.model.Supplier;
import com.ncceducation.medicalstoreMS.model.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class MedicineController {
         private static SessionFactory factory;
public MedicineController(){
      try {
            factory = this.getSession();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
}

    private SessionFactory getSession() {
     return new Configuration().configure().buildSessionFactory();//To change body of generated methods, choose Tools | Templates.
    }

    public boolean save(MedicineType mt) {
          Session session = this.openSession();
        Transaction tx = null;
        boolean result=false;
        try {
            tx = session.beginTransaction();

            session.save(mt);
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
    public ArrayList<MedicineType> getAllValues()
    {
        ArrayList<MedicineType> result = new ArrayList();
        Session session=this.openSession();
        Transaction tx=null;
        MedicineType md=new MedicineType();
        try
        {
            tx=session.beginTransaction();
                 Query query = session.createSQLQuery(
"select * from medicine_type")
.addEntity(MedicineType.class);

          List user=query.list();

            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                MedicineType us = (MedicineType) iterator.next();
                md.setTypeName(us.getTypeName());
                
                System.out.println(us.getTypeName());
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
public boolean insertRecord(Medicine user) {
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

    public Session openSession() {
        return factory.openSession();
    }

    public MedicineType getAllValues(MedicineType aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Medicine Search(int u)
    {
        Session session=this.openSession();
        Transaction tx=null;
          Medicine usr=new Medicine();
        try
        {
           
            tx=session.beginTransaction();
           // Query query = session.getNamedQuery("getbyid")
//.setString("stockCode", "1");
            
           // Query query=session.getNamedQuery("getbyid");
            //query.setParameter(0, 1);
             Medicine se = (Medicine) session.get(Medicine.class,u);
            // Query qu=session.createQuery("from user_details where id=:u");
            Query query = session.createSQLQuery(
"select * from medicine s where s.id = :stockCode")
.addEntity(Medicine.class)
.setParameter("stockCode", u);
List result = query.list();
            List user=query.list();
           
            
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Medicine us = (Medicine) iterator.next();
               usr.setId(us.getId());
                usr.setMedicine_name(us.getMedicine_name());
         
               usr.setMedicine_Type(us.getMedicine_Type());
               usr.setSupplier_name(us.getSupplier_name());
               usr.setDescription(us.getDescription());
               
               usr.setPrice(us.getPrice());
               usr.setQuantity(us.getQuantity());
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
        return usr;    
    }
    public boolean DeleteUser(Medicine u) {
        Session session = this.openSession();
        boolean con=false;
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            Medicine se=(Medicine) session.get(Medicine.class,u.getId());
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

    public boolean updateMedicine(Medicine u) {

        Session session =this.openSession();
        boolean ret=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Medicine se = (Medicine) session.get(Medicine.class,u.getId());
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
     public ArrayList<Medicine> getValues()
    {
        ArrayList<Medicine> result = new ArrayList();
        Session session=this.openSession();
        Transaction tx=null;
        Medicine md=new Medicine();
        try
        {
            tx=session.beginTransaction();
                 Query query = session.createSQLQuery(
"select * from medicine")
.addEntity(Medicine.class);

          List user=query.list();

            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Medicine us = (Medicine) iterator.next();
                md.setMedicine_name(us.getMedicine_name());
                
                
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

    public int Find(String u) {
 Session session=this.openSession();
        Transaction tx=null;
        int val=0;
          Medicine usr=new Medicine();
        try
        {
           
            tx=session.beginTransaction();
         
          //   Medicine se = (Medicine) session.get(Medicine.class,u);
         
            Query query = session.createSQLQuery(
"select * from medicine s where s.medicine_name = :stockCode")
.addEntity(Medicine.class)
.setParameter("stockCode", u);
List result = query.list();
            List user=query.list();
           
            
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Medicine us = (Medicine) iterator.next();
               val=us.getPrice();
                       
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
        return val;     
         
    }
    ////
     public boolean updateStock(Medicine u)
    {
        Session session=this.openSession();
        Transaction tx=null;
        boolean results=false;
          Medicine usr=new Medicine();
        try
        {
           
               tx=session.beginTransaction();
                 Query query = session.createSQLQuery(
"update medicine set quantity= :qty where medicine_name=:med")
.addEntity(Medicine.class)
           .setParameter("qty",u.getQuantity())
          .setParameter("med",u.getMedicine_name());
                 
             Medicine se = (Medicine) session.get(Medicine.class,u.getId());
session.update(se);             
          
           
        
List user=query.list();
          
      
          for (Iterator iterator = user.iterator(); iterator.hasNext();) {
              Medicine us = (Medicine) iterator.next();
              usr.setQuantity(us.getQuantity());
              usr.setMedicine_name(us.getMedicine_name());
                     
                
               results=true;
       
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
        return results;    
    }

    public void reduceMedicine(Medicine u,int val) {
           Session session = this.openSession();
        boolean ret=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query q=session.createSQLQuery("select quantity from medicine where medicine_name=:mname")
                    .addEntity(Medicine.class)
              .setParameter("mname",u.getMedicine_name());
              List result=q.list();
               Iterator iterator = result.iterator();
            while(iterator.hasNext()){
                int userId = (int) iterator.next();
            Query query=session.createSQLQuery("update medicine set quantity=a-val where medicine_name=:nname");
        
        query.setParameter("mname",u.getMedicine_name());
        query.setParameter("nname",u.getMedicine_name());
        int s=query.executeUpdate();
           //session.update(u);
                
           tx.commit();}
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ret=false;
            }
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
       
    }
    public List<Medicine> getAll()
    {
          Session session=this.openSession();
        Transaction tx=null;
          Medicine usr=new Medicine();
          List<Medicine> user=new ArrayList<>();
        try
        {
           
            tx=session.beginTransaction();
       
             
            Query query = session.createSQLQuery(
"select * from medicine s where s.id>0").addEntity(Medicine.class);

List result = query.list();
            user=query.list();
           
              
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Medicine us = (Medicine) iterator.next();
               usr.setId(us.getId());
               usr.setMedicine_name(us.getMedicine_name());
               usr.setMedicine_Type(us.getExpire_date());
               usr.setDescription(us.getDescription());
               usr.setSupplier_name(us.getSupplier_name());
               usr.setPrice(us.getPrice());
               usr.setQuantity(us.getQuantity());
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
     return user;
    }     

    public List<MedicineType> viewAllMedicineTypes() {
 Session session=this.openSession();
        Transaction tx=null;
          MedicineType usr=new MedicineType();
          List <MedicineType>user=new ArrayList<>();
        try
        {
         tx=session.beginTransaction();
             Query query = session.createSQLQuery(
"select * from medicine_type s where s.type_id>0").addEntity(MedicineType.class);

List result = query.list();
            user=query.list();
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                MedicineType us = (MedicineType) iterator.next();
               usr.setType_id(us.getType_id());
                usr.setTypeName(us.getTypeName());
                usr.setDescription(us.getDescription());
               }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
     
    return user;
} 



/////////////////////////////////////////////////////
         public List<Medicine> getDate()
    {
        ArrayList<Medicine> result = new ArrayList();
        Session session=this.openSession();
        Transaction tx=null;
        Medicine md=new Medicine();
        try
        {
            tx=session.beginTransaction();
                 Query query = session.createSQLQuery(
"select * from medicine")
.addEntity(Medicine.class);

          List user=query.list();

            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                Medicine us = (Medicine) iterator.next();
                md.setMedicine_name(us.getMedicine_name());
                md.setExpire_date(us.getExpire_date());
                md.setQuantity(us.getQuantity());
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
        return result;  
    }





}

    