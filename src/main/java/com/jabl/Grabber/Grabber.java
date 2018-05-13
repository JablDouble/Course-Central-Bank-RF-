package com.jabl.Grabber;


import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Grabber {

    public List<Valute> getValute(){
        List<Valute> output = new ArrayList<>();
        try {
            ValuteList valuteList = httpConnection();
            Set<Map.Entry> entries = valuteList.getValute().entrySet();
            for(Map.Entry entry : entries) {
                Map<String,Object> map1 = (Map<String, Object>) entry.getValue();
                Valute valute = new Valute();
                valute.setName((String) map1.get("Name"));
                valute.setCode((String) map1.get("CharCode"));
                valute.setNominal((Double) map1.get("Nominal"));
                valute.setValue((Double) map1.get("Value"));
                valute.setOld_value((Double) map1.get("Previous"));
                if (valute.getValue() > valute.getOld_value()){
                    valute.setCourseUp(true);
                    valute.setCourseUp_p(true);
                }else {
                    valute.setCourseUp(false);
                    valute.setCourseUp_p(false);
                }
                valute.setDifference(valute.getValue() - valute.getOld_value());
                output.add(valute);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public ValuteList httpConnection() throws IOException {
        URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        ValuteList valuteList = new Gson().fromJson(response.toString(), ValuteList.class);
        return valuteList;
    }

}
