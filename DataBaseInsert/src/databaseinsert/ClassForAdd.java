/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serhiy
 */
public class ClassForAdd {
    
        String driverName = "com.mysql.jdbc.Driver";
        String connectionUrl = "jdbc:mysql://localhost:3306/databaseforjava";
        String login = "root";
        String password = "";
        Connection connection = null;
        
        public ClassForAdd(){
            createConn();
        }
    public void createConn(){
        try{
            Class.forName(driverName);
        }catch(ClassNotFoundException ex){
            System.out.println("Driver loading error:" + ex.getLocalizedMessage());
            return;
        }
        try{
            connection = DriverManager.getConnection(connectionUrl, login, password);
            
        }catch(SQLException ex){
            System.out.println("conection error " + ex.getMessage());
            return;
        }
    }
    public void add(String name , String surname , String middlename){
        //createConn();
        try{
            String sql = "INSERT INTO User (name , surname ,miidlename) VALUES ( ?, ?, ? );";
            PreparedStatement pstat = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            
            
            pstat.setString(1, name);
            pstat.setString(2, surname);
            pstat.setString(3, middlename);
            
            int rowCount = pstat.executeUpdate();
            System.out.println("iserted rows: " + rowCount);
            
            ResultSet keyRes = pstat.getGeneratedKeys();
            if(keyRes.next()){
                System.out.println("iserted id: " + keyRes.getInt(1));
            }
            pstat.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try {
                if(!connection.isClosed())
                {
                    connection.close();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ClassForAdd.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
    }
    public void Update(int index ,String name , String surname , String middlename){
         try{
            String sql = "UPDATE user SET name = ? , surname = ? , miidlename = ? WHERE id = ?;";
            PreparedStatement pstat = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            
            
            pstat.setString(1, name);
            pstat.setString(2, surname);
            pstat.setString(3, middlename);
            pstat.setInt(4, index);
            
            pstat.executeUpdate();
            pstat.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
             try {
                 if(!connection.isClosed()){
                     connection.close();
                 }} catch (SQLException ex1) {
                 Logger.getLogger(ClassForAdd.class.getName()).log(Level.SEVERE, null, ex1);
             }
    }
    }
    public List<User> show(){
        //createConn();
        List<User> usersToReturn = new LinkedList<>();
        try{
            Statement stat = connection.createStatement();
            ResultSet users = stat.executeQuery("SELECT * FROM User ;");
            if(!users.isBeforeFirst())
            {
                System.out.println("no eny results");
            }
            //users.beforeFirst();
            while(users.next()){
                usersToReturn.add(new User(users.getInt("id") , users.getString("name") , users.getString("surname"), users.getString("miidlename")  ));
            }
            System.out.println(usersToReturn.get(usersToReturn.size()-1).getName());
            
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ClassForAdd.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return usersToReturn;
    }    
        
        
}
