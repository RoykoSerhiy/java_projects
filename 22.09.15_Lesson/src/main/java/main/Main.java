/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.DaoFactory;
import dao.UserDAO;
import entities.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.HibernateUtil;

/**
 *
 * @author Serhiy
 */
public class Main {
    public static void main(String[] args){
        testDAO();
    }
    public static void testDAO(){
        
        try
        {
        UserDAO dao = DaoFactory.getInstance().getUserDAO();
        //dao.addUser(new User("kolya", "bubkin", "rivne", "380999999999"));
        dao.addUser(new User("kolino", "azazaz", "rivne", "38099448999"));
        //dao.addUser(new User("petya", "krivorukov", "amerika", "398585878"));
        List<User> users = DaoFactory.getInstance().getUserDAO().getUsersByNameTplAndId("kol%", 1);
            printUsers(new ArrayList<User>(users));
            HibernateUtil.getSessionFactory().close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("dao completed");
    }
    private static void printUsers(ArrayList<User> users){
        if(users != null && users.size() != 0)
        {
		System.out.println("======== Users ========");
		for(User user: users) { 
				System.out.println(
						"Name : " + user.getName() 
						+ ", Surname : " + user.getSurname()
						+ ",  Address : " + user.getAddress()
                                                + ", Phone : " + user.getPhone());
				System.out.println("=============================");
			}       
	}else{
            System.out.println("list maybe empty size = " + users.size());
        }
    }
}
