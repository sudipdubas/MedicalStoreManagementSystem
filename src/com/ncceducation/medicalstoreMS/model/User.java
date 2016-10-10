/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncceducation.medicalstoreMS.model;

import com.ncceducation.medicalstoreMS.Controller.UsersController;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author sudip dubas
 */


@javax.persistence.Entity
@javax.persistence.Table(name = "user_details")
public class User{
    @Id @GeneratedValue
    private int id;
    private String first_name;
   private String last_name;
   private String address;
   private String contact_no;
   private String username;
   private String password;
   private String repassword;

 

    /**
     * @return the id
     */
  public void User(int id, String first_name, String last_name, String address, String contact_no, String username, String password){
 this.id=id;
 this.first_name=first_name;
 this.last_name=last_name;
 this.address=address;
 this.contact_no=contact_no;
 this.username=username;
this.password=password;
   }
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the first_name
     */
   // @NotEmpty
    
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
   // @NotEmpty
    
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the address
     */
   // @NotEmpty
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact_no
     */
    //@NotEmpty
    public String getContact_no() {
        return contact_no;
    }
        /**
     * @param contact_no the contact_no to set
     */
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    /**
     * @return the username
     
    @NotEmpty
    @Length(min=5, max=10)
    @Id
    @Column(name="username", unique=true,nullable=false, length=255)*/
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
   //This fucntions returns maximum id number from the database
    public int getNewID(){
        UsersController c=new UsersController();
        return(c.getMaxId());
    }
    
    //This functions take the users information and saves it to database and returns boolean value
    public boolean save(){
        UsersController c1=new UsersController();
        return(c1.insertRecord(this));
    }
   //This function deletes user from the database and returns boolean value
    public boolean DeleteUser(){
            UsersController d=new UsersController();
   return( d.DeleteUser(this));
    
}
    //THis function updates users information and return boolean value
    public boolean updateUser(){
              UsersController d=new UsersController();
              return(d.updateUser(this));
    }
//Funtion to search the value of partucular user using user id
    public User Search(int a) {
       UsersController db = new UsersController();
        return (db.Search(a));
    }

    /**
     * @return the repassword
     */
    public String getRepassword() {
        return repassword;
    }

    /**
     * @param repassword the repassword to set
     */
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public User Login() {
    UsersController db = new UsersController();
        return (db.Login(this));    }
    
 public boolean updatePassword(){
     UsersController us=new UsersController();
     return(us.updatePassword(this));
     
 }   

   public List<User> ViewAllUser() {
        UsersController db = new UsersController();
        return (db.ViewAllUser(this));
    }

}
    