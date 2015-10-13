/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8lessson;

/**
 *
 * @author Serhiy
 */
public interface User {
    String getName();
    default int compare(User a){
        return getName().compareTo(a.getName());
    }
}
