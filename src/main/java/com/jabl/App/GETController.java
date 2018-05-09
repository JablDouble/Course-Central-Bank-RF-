package com.jabl.App;

import com.jabl.Grabber.Grabber;
import com.jabl.Grabber.Valute;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class GETController {
    Val value = new Val();

    @RequestMapping(value = "course", method= RequestMethod.GET)
    public String course(Model model) throws IOException {
        List<Valute> valutes = new Grabber().getValute();
        for (Valute valute:valutes) {
            if(valute.getCode().equals("GBP")){
                valute.setName("Фунт стерлингов Великобритании");
            }

            double newDouble = new BigDecimal(valute.getDifference()).setScale(3, RoundingMode.UP).doubleValue();
            valute.setDifference(newDouble);
        }
        model.addAttribute("select",valutes);
        model.addAttribute("category",valutes);
        model.addAttribute("val", value);
        return "course";
    }

    //@RequestParam(name="name", required=false, defaultValue="World") String name
    @RequestMapping(value = "course", method= RequestMethod.POST)
    public String course(@ModelAttribute("val") Val val, BindingResult result, Model model) throws IOException {
        List<Valute> valutes = new Grabber().getValute();
        List<Valute> output = new ArrayList<>();
        for (Valute valute:valutes) {
            if(valute.getCode().equals("GBP")){
                valute.setName("Фунт стерлингов Великобритании");
            }
            LinkedHashMap<String,Object> modelMap = (LinkedHashMap<String, Object>) result.getModel();
            Val value = (Val) modelMap.get("val");
            List<String> content = value.getContent();
            for (String code:content) {
                if(valute.getCode().equals(code)){
                    output.add(valute);
                }
            }


            double newDouble = new BigDecimal(valute.getDifference()).setScale(3, RoundingMode.UP).doubleValue();
            valute.setDifference(newDouble);
        }
        model.addAttribute("select",valutes);
        model.addAttribute("category",output);
        return "course";
    }

    @RequestMapping(value = "converter", method= RequestMethod.GET)
    public String converter(Model model) {
        List<Valute> valutes = new Grabber().getValute();
        model.addAttribute("category",valutes);
        model.addAttribute("int",new Val());
        return "converter";
    }

    @RequestMapping(value = "converter", method= RequestMethod.POST)
    public String converter(@ModelAttribute Val val,Model model) throws IOException {
        return "test";
    }

}