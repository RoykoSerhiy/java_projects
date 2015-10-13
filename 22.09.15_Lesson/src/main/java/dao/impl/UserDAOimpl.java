/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UserDAO;
import entities.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Serhiy
 */
public class UserDAOimpl implements UserDAO{

    @Override
    public void addUser(User u) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateUser(User u) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(u);
            session.getTransaction().commit();
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    
    @Override
    public void deleteUser(User u) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(u);
            session.getTransaction().commit();
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<User> getUsersByNameTplAndId(String tpl, Integer id) {
        ArrayList<User> users = new ArrayList<User>();
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = session.createCriteria(User.class)
					.add(Restrictions.gt("id", id)) // gt - greater then
					.add(Restrictions.and(Restrictions.like("name", tpl)));
			users = (ArrayList<User>) crit.list();
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(session != null & session.isOpen()){
                session.close();
            }
        }
        return users;
    }
}
