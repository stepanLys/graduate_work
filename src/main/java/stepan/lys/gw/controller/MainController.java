package stepan.lys.gw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping()
    public String printHello(ModelMap model) {

        model.addAttribute("message", "Hello Spring MVC Framework!");
        model.addAttribute("isDevMode", true);


        return "index";
    }


}
