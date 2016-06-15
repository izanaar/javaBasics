package com.spittr.model;

public class SimpleBean {

    private String strVal;

    public SimpleBean() {
    }

    public SimpleBean(String strVal) {
        this.strVal = strVal;
    }

    public String getStrVal() {
        return strVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "strVal='" + strVal + '\'' +
                '}';
    }
}
