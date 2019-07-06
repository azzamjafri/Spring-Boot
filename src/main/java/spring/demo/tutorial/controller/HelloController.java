package spring.demo.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class HelloController {

    static ArrayList<String> cheeses = new ArrayList<>();


    @RequestMapping(value = "")
    public String index(Model model) {

//        cheeses.add("cheddar");
//        cheeses.add("parmesan");
//        cheeses.add("munster");
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model){

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        cheeses.add(cheeseName);
        return "redirect:";
    }

}
