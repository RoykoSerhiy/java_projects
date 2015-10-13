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
public class Users {
    User[] list;
    int current = 0;
    public Users(){
        list = new User[10];
    }
    public void add(User user){
        if(current < 10){
            list[++current] = user;
        }
    }
//    public void add(User[] users){
//        for(int i = 0;i<users.length;i++){
//            add(users[i]);
//        }
//    }
    public void add(User... users){
        for(int i = 0;i<users.length;i++){
            add(users[i]);
        }
    }
    public String info(){
        String res = "";
        for(User user : list){
            if(user != null)
            {
                res += user.getName() + "[" + Integer.toString(user.getAge()) + "]\n";
            }       
       }
        return res;
    }
}
