package com.jabl.Converter;

import com.jabl.Grabber.Grabber;
import com.jabl.Grabber.Valute;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Double> convertation(long money, String code, List<String> toConvert) {
        List<Valute> valutes = new Grabber().getValute();
        List<Double> output = new ArrayList<>();
        double course = 0;
        for (Valute valute : valutes) {
            if (valute.getCode().equals(code)) {
                course = valute.getValue();
                course *= money;
                System.out.println(course);
                for (String convert:toConvert) {
                    for (Valute val : valutes) {
                        if (val.getCode().equals(convert)) {
                            double result = (course/val.getValue());
                            result = new BigDecimal(result).setScale(4, RoundingMode.UP).doubleValue();
                            output.add(result);
                        }
                    }
                }
            }
        }
        return output;
    }
}
