package com.jabl.App;

import java.util.List;

public class Val {
    private int id;
    private List<String> content;
    private List<String> selectMoney;
    private List<Double> outputConvert;
    private long convert;
    private String money;

    public Val(int id, List content) {
        this.id = id;
        this.content = content;
    }

    public Val() {
    }

    public List<String> getSelectMoney() {
        return selectMoney;
    }

    public void setSelectMoney(List<String> selectMoney) {
        this.selectMoney = selectMoney;
    }

    public long getConvert() {
        return convert;
    }

    public void setConvert(long convert) {
        this.convert = convert;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }

    public List<Double> getOutputConvert() {
        return outputConvert;
    }

    public void setOutputConvert(List<Double> outputConvert) {
        this.outputConvert = outputConvert;
    }
}
