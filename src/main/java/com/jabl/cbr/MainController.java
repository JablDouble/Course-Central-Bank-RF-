package com.jabl.cbr;

import com.jabl.Grabber.Grabber;
import com.jabl.Grabber.Valute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws IOException {
        List<Valute> valutes = new Grabber().getValute();
        for (Valute valute:valutes) {
            if(valute.getCode().equals("GBP")){
                valute.setName("Фунт стерлингов Великобритании");
            }
        }
        model.addAttribute("category",valutes);
        return "index";
    }

    @GetMapping("/t")
    public String gree() {
        return "index";
    }

}