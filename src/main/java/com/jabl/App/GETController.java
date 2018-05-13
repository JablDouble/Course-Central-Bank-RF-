package com.jabl.App;

import com.jabl.Converter.Converter;
import com.jabl.Grabber.Grabber;
import com.jabl.Grabber.Valute;
import com.jabl.Grabber.ValuteList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

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
            if (content == null){
                output.add(valute);
            }
            if(content!=null) {
                for (String code : content) {
                    if (valute.getCode().equals(code)) {
                        output.add(valute);
                    }
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
        String date = null;
        try {
            Date dat = new Grabber().httpConnection().getDate();
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            date = newDateFormat.format(dat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("date",date);
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
        String date = null;
        try {
            Date dat = new Grabber().httpConnection().getDate();
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            date = newDateFormat.format(dat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("date",date);
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