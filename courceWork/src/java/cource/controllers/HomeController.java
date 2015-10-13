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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Serhiy
 */
@Controller
public class HomeController extends BasicController{
    
        @Autowired
        private PostDAO dao;
        @Autowired
        private UserDAO udao; 
    
    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public String home(ModelMap model){
        boolean isAuthorized = isAutorized();
        List<Post> posts = dao.list(10);
        Map<Long , User> users = new HashMap<>();
        List<Long> users_ids = new ArrayList<>();
        for(Post p : posts)
        {
            users_ids.add(p.getUserId());
        }
        users = udao.getUsers(users_ids);
        model.addAttribute("posts" , posts);
        model.addAttribute("users" , users);
        model.addAttribute("isAuthorized", isAuthorized);
        //System.out.println(users.size()+"+"+users_ids.size());
        return "home";
    }
}
