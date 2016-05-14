package com.izanaar.model;

import java.io.Serializable;

public class Translation implements Serializable{
    private String inputText;
    private String inputLanguage;
    private String finalLanguage;

    public Translation() {
    }

    public Translation(String text, String src, String dst) {
        inputText = text.trim();
        inputLanguage = src;
        finalLanguage = dst;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Translation)){
            return false;
        }

        Translation comparable = (Translation)obj;

        return this.inputText.equals(comparable.inputText) &&
                this.inputLanguage.equals(comparable.inputLanguage) &&
                this.finalLanguage.equals(comparable.finalLanguage);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return inputText + ("(" + inputLanguage + "-" + finalLanguage + ")");
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputLanguage() {
        return inputLanguage;
    }

    public void setInputLanguage(String inputLanguage) {
        this.inputLanguage = inputLanguage;
    }

    public String getFinalLanguage() {
        return finalLanguage;
    }

    public void setFinalLanguage(String finalLanguage) {
        this.finalLanguage = finalLanguage;
    }
}
