/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hybernamelesson;

import entities.User;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Serhiy
 */
public class HybernameLesson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        startSql();
    }
    public static void startSql(){
        Session session = null;
         //query = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
        Query query1 = session.createSQLQuery("INSERT INTO users (id , name , surname , address , phone) VALUES (?,?, ?, ?, ?);").addEntity(User.class);
        query1.setInteger(0, 1);
        query1.setString(1, "vasya");
        query1.setString(2, "pupkin");
        query1.setString(3, "gdeto tam");
        query1.setString(4, "132123321");
        query1.executeUpdate();
            
        Query query2 = session.createSQLQuery("SELECT * FROM users ;")
					.addEntity(User.class);
			List<User> users = query2.list();
                        printUsers(new ArrayList<User>(users));
			
			
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
    }
    private static void printUsers(ArrayList<User> users){
		System.out.println("======== Users ========");
		for(User user: users) { 
				System.out.println(
						"Name : " + user.getName() 
						+ ", Surname : " + user.getSurname()
						+ ",  Address : " + user.getAddress()
                                                + ", Phone  : " + user.getPhone());
				System.out.println("=============================");
			}       
	}
}
