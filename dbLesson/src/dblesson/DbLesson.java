/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dblesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serhiy
 */
public class DbLesson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
    public static void connect(){
        String driverName = "com.mysql.jdbc.Driver";
        String connectionUrl = "jdbc:mysql://localhost:3306/databaseforjava";
        String login = "root";
        String password = "";
        Connection connection = null;
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
        
        try{
            Statement stat = connection.createStatement();
            ResultSet users = stat.executeQuery("SELECT * FROM User WHERE id >= 1 LIMIT 0,3 ;");
            if(!users.isBeforeFirst())
            {
                System.out.println("no eny results");
            }
            while(users.next()){
                String info = "" + 
                        "\n id:" + users.getInt("id") +
                        "\n name:" + users.getString("name") +
                        "\n surname:" + users.getString("surname") + 
                        "\n middlename:" + users.getString("miidlename") + 
                        "\n";
                        System.out.println(info);
            }
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbLesson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
