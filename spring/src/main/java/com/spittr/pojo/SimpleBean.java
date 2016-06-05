package com.spittr.pojo;

public class SimpleBean {

    private String strVal;

    public SimpleBean() {
    }

    public SimpleBean(String strVal) {
        this.strVal = strVal;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "strVal='" + strVal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleBean that = (SimpleBean) o;

        return strVal != null ? strVal.equals(that.strVal) : that.strVal == null;

    }

    @Override
    public int hashCode() {
        return strVal != null ? strVal.hashCode() : 0;
    }

    public String getStrVal() {
        return strVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }
}
