package com.jabl.App;

import com.jabl.Converter.Converter;
import com.jabl.Grabber.Grabber;
import com.jabl.Grabber.Valute;
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
        model.addAttribute("val", new Val());
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
        Val val = new Val();
        List<Double> Zerolist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Zerolist.add(0.0);
        }
        val.setOutputConvert(Zerolist);
        System.out.println(val.getOutputConvert());
        model.addAttribute("convert",val.getOutputConvert());
        model.addAttribute("category",valutes);
        model.addAttribute("int",val);
        return "converter";
    }

    @RequestMapping(value = "converter", method= RequestMethod.POST)
    public String converter(@ModelAttribute Val val,Model model, BindingResult result) throws IOException {
        LinkedHashMap<String,Object> modelMap = (LinkedHashMap<String, Object>) result.getModel();
        List<Valute> valutes = new Grabber().getValute();
        Val value = (Val) modelMap.get("val");
        Converter converter = new Converter();
        val.setOutputConvert(converter.convertation(value.getConvert(),value.getMoney(),value.getSelectMoney()));
        System.out.println(val.getOutputConvert());
        model.addAttribute("convert",val.getOutputConvert());
        model.addAttribute("int",val);
        model.addAttribute("category",valutes);
        return "converter";
    }

    @RequestMapping(value = "contacts",method = RequestMethod.GET)
    public String contact(Model model){
        return "contact";
    }
}