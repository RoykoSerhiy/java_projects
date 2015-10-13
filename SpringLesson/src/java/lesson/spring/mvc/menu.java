/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson.spring.mvc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 *
 * @author Serhiy
 */
@Controller

public class menu {
    List<String> anekdots = new ArrayList<>();
    public menu(){
        anekdots.add("Каждый мужчина в итоге выбирает ту девушку, которая верит в него больше, чем он сам.");
        anekdots.add("Каждый живёт хорошо, пока не узнает, что живёт плохо. После этого он уже живёт плохо.");
        anekdots.add("Два гангстера, ограбившие банк, пытаются оторваться от полицейского преследования на автомобиле.\n" +
                        "- Смотри, Джек, как несправедлива жизнь - каждый раз, когда у тебя появляются деньги, сразу возникают проблемы.");
        anekdots.add("- Да, жизнь проходит, пора и о карьере задуматься.\n" +
                        "- Петрович, хорош болтать, садись в свой экскаватор и вали в карьер, твоя смена!");
        anekdots.add("Сара Рабинович была такой толстой, что во время прослушивания волнующей музыки мурашки, бегущие по её телу, умирали от усталости уже на первом круге...");
    }
    @RequestMapping(value = "/anek")
    public String menu(@RequestParam("page")String page , ModelMap model){
        int index = Integer.parseInt(page);
        String text = anekdots.get(index-1);
        model.addAttribute("content", text);
        return "menu";
    }
}
