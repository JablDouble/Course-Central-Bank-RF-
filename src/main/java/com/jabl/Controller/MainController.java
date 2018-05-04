package com.jabl.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/main")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        int a = 63;
        for (int i = 0; i < 100; i++) {
            System.out.println(a);
        }
        model.addAttribute("usd",a);
        return "index";
    }

    @GetMapping("/t")
    public String gree() {
        return "index";
    }

}