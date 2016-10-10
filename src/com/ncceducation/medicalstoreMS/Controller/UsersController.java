/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.Controller;

import static com.ncceducation.medicalstoreMS.View.Dashboard.usr;
import com.ncceducation.medicalstoreMS.model.Medicine;
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
        User usr=new User();
        try
        {
            tx=session.beginTransaction();
             Query query = session.createSQLQuery(
                "select max(id) from user_details ")
                .addEntity(User.class);
             List user=query.list();
        for (Iterator iterator = user.iterator(); iterator.hasNext();) {          
            User us = (User) iterator.next();
            usr.setId(us.getId());
            
           
       
         }
   
          
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

             User se = (User) session.get(User.class,u);
      
            Query query = session.createSQLQuery(
"select * from user_details s where s.id= :stockCode")
.addEntity(User.class)
.setParameter("stockCode", u);
            session.save(se);
List result = query.list();
            List user=query.list();
           
            
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                User us = (User) iterator.next();
               usr.setId(us.getId());
                usr.setFirst_name(us.getFirst_name());
                        System.out.println(us.getFirst_name());

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

    public User Login(User u) {
Session session=this.openSession();
        Transaction tx=null;
          User usr=new User();
        try
        {
           
            tx=session.beginTransaction();
            Query query = session.createSQLQuery(
"select * from user_details s where s.username= :uname and s.password=:upass")
.addEntity(User.class)
                    .setParameter("uname", u.getUsername())
.setParameter("upass", u.getPassword());

            List user=query.list();
            if(user.isEmpty())
            {
                return usr=null;
            }
            else{
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                User us = (User) iterator.next();
               usr.setId(us.getId());
                usr.setFirst_name(us.getFirst_name());
                usr.setUsername(us.getUsername());
               usr.setPassword(us.getPassword());
               
            }}
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
        return usr;       
    }

    public boolean updatePassword(User u) {
     
        Session session = this.openSession();
        boolean ret=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
           Query query = session.createSQLQuery("update user_details set password = :docname" + " where username = :docId");
query.setParameter("docname",u.getPassword());
query.setParameter("docId",u.getUsername());
int result = query.executeUpdate();
           
           
        int s=query.executeUpdate();
           //session.update(se);
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

    public List<User> ViewAllUser(User u) {
           
 Session session=this.openSession();
        Transaction tx=null;
          User usr=new User();
          List <User>user=new ArrayList<>();
        try
        {
           
            tx=session.beginTransaction();
       
             
            Query query = session.createSQLQuery(
"select * from user_details s where s.id>0").addEntity(User.class);

List result = query.list();
            user=query.list();
           
              
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                User us = (User) iterator.next();
               usr.setId(us.getId());
                usr.setFirst_name(us.getFirst_name());
                        
                
                
                System.out.println(us.getFirst_name());

               usr.setLast_name(us.getLast_name());
               usr.setAddress(us.getAddress());
               usr.setContact_no(us.getContact_no());
               
               usr.setUsername(us.getUsername());
       
            }
        }catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(ex.getMessage());
        } 
     
    return user;
}


  
}