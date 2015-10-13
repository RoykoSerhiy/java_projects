/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;



/**
 *
 * @author Serhiy
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
    private Integer id;
    private String  name;
    private String  surname;
    private String  address;
    private String  phone;
    
    public User(){}
    
    public User(String name , String surname , String address , String phone){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }
     @Id
     @GeneratedValue(generator = "increment")
     @GenericGenerator(name="increment", strategy="increment")
     @Column(name = "id")
     public Integer getId(){
         return this.id;
     }
     @Column(name = "name")
     public String getName(){
         return this.name;
     }
     @Column(name = "surname")
     public String getSurname(){
         return this.surname;
     }
     @Column(name = "address")
     public String getAddress(){
         return this.address;
     }
     @Column(name = "phone")
     public String getPhone(){
         return this.phone;
     }
     public void setId(Integer id){
         this.id = id;
     }
     public void setName(String name){
         this.name = name;
     }
     public void setSurname(String surname){
         this.surname = surname;
     }
     public void setAddress(String address){
         this.address = address;
     }
     public void setPhone(String phone){
         this.phone = phone;
     }
}
