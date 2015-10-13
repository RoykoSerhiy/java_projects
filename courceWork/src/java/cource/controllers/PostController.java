/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.controllers;

import cource.dao.interfaces.CommentDAO;
import cource.dao.interfaces.PostDAO;
import cource.dao.interfaces.UserDAO;
import cource.entities.Comment;
import cource.entities.Post;
import cource.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Serhiy
 */
@Controller
@RequestMapping("/post")
public class PostController extends BasicController {
    @Autowired
    private PostDAO dao;
    @Autowired
    private CommentDAO cdao;
    @Autowired
    private UserDAO udao;
    
    @RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create(){
                if(((User)getSession().getAttribute("user")) == null){
                  return new ModelAndView("auth/login");
                }
		Post post = new Post();
		String userId = getRequest().getParameter("user");
               // System.out.println(userId);
		ModelAndView model = new ModelAndView("post/form", "post", post);
		model.addObject("userId", userId);
		return model;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView create(@PathVariable("id") long id){
		
		return new ModelAndView("post/form", "post", new Post(id));
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String editHandler(@ModelAttribute("post") Post post, 
			@RequestParam(value="user_id") Long user_id,
			ModelMap model){
                if(((User)getSession().getAttribute("user")) == null){
                        return "redirect:../auth/login";
                }
		post.setUserId(((User)getFromSession("user")).getId());
                //System.out.println("post id: " + post.getId());
                System.out.println(post.getId());
                if(post.getId() == null){
                    post.setId(new Long(0));
                }
		if(post.getId() == 0){
			
			dao.create(post);
		} else {
			
			dao.update(post);
		}
		return "redirect:/post/view?post=" + post.getId();
	}
        
        @RequestMapping(value="/view", method=RequestMethod.GET)
        public String view(ModelMap model){
            boolean authorized = isAutorized();
            
           
            
            if(authorized == false && getRequest().getParameter("post") == null){
                return "redirect:../auth/login";
            }
            
            
            Post p = dao.getById(Long.parseLong(getRequest().getParameter("post")));
            
            User u = udao.readById(p.getUserId());
            
            List<Comment> comments = cdao.list(p.getId());
            List<Long> ids = new ArrayList<>();
            for(Comment c : comments){
                ids.add(c.getAuthorId());
            }
            Map<Long , User> users = udao.getUsers(ids);
            model.addAttribute("post", p);
            model.addAttribute("user", u);
            model.addAttribute("comments" , comments);
            model.addAttribute("users" , users);
            model.addAttribute("authorized" , authorized);
            
            return "post/view";
            
        }
        @RequestMapping(value="/del/{id}", method=RequestMethod.GET)
        public String delete(@PathVariable("id") long id){
            if(((User)getSession().getAttribute("user")) == null){
                return "redirect:../auth/login";
            }
            dao.delete(id);
            return "redirect:/user/profile";
        }
}
