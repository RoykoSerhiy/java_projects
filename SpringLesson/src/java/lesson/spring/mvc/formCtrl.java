/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Serhiy
 */
@Controller
public class formCtrl {
    @RequestMapping(value = "/form")
    public String show()
    {
       
        return "form";
    }
    @RequestMapping(value = "/formCtrl" , method = RequestMethod.POST)
    public String show(@RequestParam("login")String login , @RequestParam("password")String password, ModelMap model)
    {
        model.addAttribute("login" , login);
        model.addAttribute("password" , password);
        return "form";
    }
}
