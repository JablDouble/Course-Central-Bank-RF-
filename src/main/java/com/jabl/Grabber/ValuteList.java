package com.jabl.Grabber;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ValuteList {
    @SerializedName("Valute")
    private Map<String,Map<String,Object>> ValuteList;

    public Map getValute() {
        return ValuteList;
    }

    public void setValute(Map valute) {
        ValuteList = valute;
    }

}
