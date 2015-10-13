/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializationlesson;

/**
 *
 * @author Serhiy
 */
public class Address {
    String street;
    int number;
    int apartment;
    public Address(){
        
    }
    public Address(String street ,int number ,int apartment){
        this.street = street;
        this.number = number;
        this.apartment = apartment;
    }
    public String getStreet(){
        return street;
    }
    public int getNumber(){
        return number;
    }
    public int getApartment(){
        return apartment;
    }
    public void setStreet(String s){
        this.street = s;
    }
    public void setNumber(int n){
        this.number = n;
    }
    public void setApartment(int a){
        this.apartment = a;
    }
}
