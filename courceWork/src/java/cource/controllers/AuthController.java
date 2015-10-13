/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.controllers;


import cource.dao.interfaces.UserDAO;
import cource.entities.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/auth")
public class AuthController extends BasicController{
    @Autowired
    UserDAO udao;
    
    @RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerForm(ModelMap model){
		
		return new ModelAndView("auth/reg_form", "user", new User());
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerHandler(@ModelAttribute("user")  User user, 
			BindingResult result, 
			HttpServletRequest request,
                        ModelMap model){
		if(result.hasErrors()){
                    //System.out.println("error count:"+result.getErrorCount());
			return "auth/reg_form";
		}
		user = udao.create(user);
		setToSession("user", user);
                model.addAttribute("user", user);
		return "redirect:/user/profile";
	}
        
        @RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginForm(@RequestParam(value = "incorrect", required = false) String incorrect, ModelMap model){
		model.addAttribute("incorrect", (incorrect != null ? incorrect.equalsIgnoreCase("yes") : false) );
		ModelAndView mv = new ModelAndView("auth/login_form", "user", new User());
		return mv;
	}
        @RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginHandler(@RequestParam("login") String login,
			@RequestParam("pass") String password,
			ModelMap model){
		User user = udao.checkByLoginAndPassword(login, password);
		if(user == null || user.getId() == null){
			model.addAttribute("incorrect", "yes");
			model.addAttribute("form", login+"-"+password);
			model.addAttribute("nouser", (user == null ? "null" : user.getName()));
			return "redirect:/auth/login";
		}
		setToSession("user", user);
                model.addAttribute("user" , user);
		return "redirect:/user/profile";
	}
        @RequestMapping(value="/logout")
	public String logout(){
            delFromSession("user");
            return "redirect:/user/profile";
	}
}
