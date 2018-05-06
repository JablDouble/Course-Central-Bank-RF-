package com.jabl.cbr;

import com.jabl.Grabber.Grabber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws IOException {
        int a = 63;
        model.addAttribute("count",1);
        model.addAttribute("usd",a);
        Grabber grabber = new Grabber();
        return "index";
    }

    @GetMapping("/t")
    public String gree() {
        return "index";
    }

}