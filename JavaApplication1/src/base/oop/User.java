/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.oop;

/**
 *
 * @author Serhiy
 */
public class User {
    private String name;
    private int age;
    public User(){
        
    }
    public User(String name , int age){
        setName(name);
        setAge(age);
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
}
