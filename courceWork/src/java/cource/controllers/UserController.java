/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.controllers;

import cource.dao.interfaces.PostDAO;
import cource.dao.interfaces.UserDAO;
import cource.entities.Post;
import cource.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author Serhiy
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BasicController{
    
    @Autowired
    PostDAO pdao;
    @Autowired
    UserDAO udao;
    
    
    
    //test method,must be modefied
    @RequestMapping(value = "/profile")
    public String profile(ModelMap model){
        boolean isAuthorized = isAutorized();
        List<Post> posts = new ArrayList<>();
        User u = new User();
        if(isAuthorized == false && getRequest().getParameter("uid") == null){
            return "redirect:../auth/login";
        }
        if(getRequest().getParameter("uid") != null)
        {
            Long uid = Long.parseLong(getRequest().getParameter("uid"));
            posts = pdao.getByAuthorId(uid);
            u = udao.readById(uid);
        }else
        if(isAuthorized == true)
        {
            u = (User)getFromSession("user");
            //System.out.println(u);
            posts = pdao.getByAuthorId(((User)getFromSession("user")).getId());
        }
        model.addAttribute("authorized" , isAuthorized);
        model.addAttribute("posts" , posts);
        model.addAttribute("user", u);
        return "user/profile";
    }
    

}
