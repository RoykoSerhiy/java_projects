/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junittest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Serhiy
 */
public class Band {
    List<User> users = new ArrayList<>();
    
    public void addUser(User user){
        users.add(user);
    }
    public int[] getAges(){
        int[] arr = new int[users.size()];
        int count = 0;
        for(User u : users){
            arr[count] = u.getAge();
            count++;
        }
        return arr;
    }
}
