/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Serhiy
 */
@Controller
public class Hello {
    public Hello(){
        
    }
    @RequestMapping({"/hello"})
    public String helloMethod(){
        return "hello";
    }
}
