package org.learnteachcode.seoul.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloPage {

    @RequestMapping("/")
    public String hello(
            @RequestParam(value = "pokemon",
                    required = false,
                    defaultValue = "mudkips")
                    String pokemon,
            Model model) {
        model.addAttribute("pokemon", pokemon);
        return "hello";
    }
}
