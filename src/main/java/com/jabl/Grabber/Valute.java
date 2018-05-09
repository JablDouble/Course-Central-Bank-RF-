package com.jabl.Grabber;

public class Valute {
    private String name;
    private Double nominal;
    private String code;
    private double value;
    private double old_value;
    private double difference;
    private boolean courseUp;
    private boolean courseUp_p;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getOld_value() {
        return old_value;
    }

    public void setOld_value(double old_value) {
        this.old_value = old_value;
    }

    public boolean isCourseUp() {
        return courseUp;
    }

    public void setCourseUp(boolean courseUp) {
        this.courseUp = courseUp;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public boolean isCourseUp_p() {
        return courseUp_p;
    }

    public void setCourseUp_p(boolean courseUp_p) {
        this.courseUp_p = courseUp_p;
    }
}
