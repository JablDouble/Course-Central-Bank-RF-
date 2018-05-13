package com.jabl.Grabber;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ValuteList {
    @SerializedName("Valute")
    private Map<String,Map<String,Object>> ValuteList;
    @SerializedName("Date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map getValute() {
        return ValuteList;
    }

    public void setValute(Map valute) {
        ValuteList = valute;
    }

}
