/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.controllers;

import cource.dao.interfaces.CommentDAO;
import cource.entities.Comment;
import cource.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Serhiy
 */
@Controller
@RequestMapping(value="/comment")
public class CommentController extends BasicController{
    @Autowired
    CommentDAO cdao;
    
   
    
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@RequestParam("description")String desc, @RequestParam("post_id")Long post_id, ModelMap model){
        if(((User)getSession().getAttribute("user")) == null){
            return "redirect:../auth/login";
        }
        //model.addAttribute("comment", comment);
        Comment comment = new Comment();
        comment.setPostId(post_id);
        comment.setAuthorId(((User)getFromSession("user")).getId());
        comment.setDescription(desc);
        cdao.create(comment);
        
        return "redirect:../post/view?post="+post_id;
    }
}
