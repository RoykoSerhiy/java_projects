/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.controllers;

import cource.entities.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Serhiy
 */
public class BasicController {
    //Map<String, Cookie> cookies = new HashMap<>();
	
	public BasicController(){
//		Cookie[] cookieArr = getRequest().getCookies();
//		for(Cookie c: cookieArr){
//			cookies.put(c.getName(), c);
//		}
	}
	
        public boolean isAutorized(){
            if(currentUser() == null){
                return false;
            }
            return true;
        }
        
	public User currentUser(){
		return (User)getFromSession("user");
	}
	
	public HttpServletRequest getRequest(){
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
	}
	
	public HttpSession getSession(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attr.getRequest().getSession(true);
	}
	
	public Object getFromSession(String key){
		return getSession().getAttribute(key);
	}
	
	public void setToSession(String key, Object attribute){
		getSession().setAttribute(key, attribute);
	}
        public void delFromSession(String key){
            getSession().removeAttribute(key);
        }
}
