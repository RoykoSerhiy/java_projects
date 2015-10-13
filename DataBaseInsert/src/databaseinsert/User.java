/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseinsert;

/**
 *
 * @author Serhiy
 */
public class User {
    public int id;
    public String name;
    public String surname;
    public String middlename;
    public User(int id , String n , String sn, String mn){
        this.id = id;
        this.name = n;
        this.surname = sn;
        this.middlename = mn;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getMiddlename(){
        return middlename;
    }
    @Override
    public String toString(){
        return id + "." + name + " " + surname + " " + middlename;
                
    }
    
}
