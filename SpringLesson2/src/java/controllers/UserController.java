/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserDAO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Serhiy
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private UserDAO udao;
    
    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public ModelAndView createForm(ModelMap model){
        return new ModelAndView("user/form" , "userForm" , new User());
    }
    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public String createHandler(@ModelAttribute("userForm") User user , ModelMap model){
        model.addAttribute("name" , user.getName());
        model.addAttribute("pass" , user.getPass());
        model.addAttribute("email" , user.getEmail());
        model.addAttribute("login" , user.getLogin());
        model.addAttribute("user", udao.craete(user));
        
        return "user/info";
    }
    @RequestMapping("/cookie") 
    public String testCookie(@RequestParam(value = "word" ,required = false,defaultValue = "noWord")String word,
            @CookieValue(value = "prevWord" , required = false,defaultValue = "noOldWord") String prevWord ,
            HttpServletResponse response,ModelMap model){
        Cookie cookie = new Cookie("prevWord" , word);
        response.addCookie(cookie);
        model.addAttribute("newValue" , word);
        model.addAttribute("oldValue" , prevWord);
        return "cookieTest";
    }
    
    @RequestMapping("/info")
    public String userInfo(@RequestParam(value = "id" , required = false  , defaultValue = "1")Long id , 
            ModelMap model){
        User user = udao.readByID(id);
        model.addAttribute("user",user);
        return "user/info";
    }
//    @RequestMapping(value={"/info"}, method = RequestMethod.GET)
//	public String info(ModelMap model){
//		model.addAttribute("daotest", udao.test());
//		return "user/empty";
//	}
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
