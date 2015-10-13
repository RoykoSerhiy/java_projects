/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.UserDAOimpl;

/**
 *
 * @author Serhiy
 */
public class DaoFactory {
    private static UserDAO userDAO = null;
    private static DaoFactory instanse = null;
    
    
    public static synchronized DaoFactory getInstance(){
        if(instanse == null){
            instanse = new DaoFactory();
        }
        return instanse;
    }
    public UserDAO getUserDAO(){
        if(userDAO == null){
            userDAO = new UserDAOimpl();
        }
        return userDAO;
    }
}
