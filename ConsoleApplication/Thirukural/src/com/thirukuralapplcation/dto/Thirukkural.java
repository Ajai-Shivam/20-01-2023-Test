package com.thirukuralapplcation.dto;

public class Thirukkural {
    private int Number;
    private String Line1;
    private String Line2;
    private String Translation;
    private String mv;
    private String sp;
    private String mk;
    private String explanation;
    private String couplet;
    private String transliteration1;
    private String transliteration2;

    public Thirukkural(){

    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setLine1(String line1) {
        Line1 = line1;
    }

    public void setLine2(String line2) {
        Line2 = line2;
    }

    public void setTranslation(String translation) {
        Translation = translation;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setCouplet(String couplet) {
        this.couplet = couplet;
    }

    public void setTransliteration1(String transliteration1) {
        this.transliteration1 = transliteration1;
    }

    public void setTransliteration2(String transliteration2) {
        this.transliteration2 = transliteration2;
    }

    public String getLine1() {
        return Line1;
    }

    public String getLine2() {
        return Line2;
    }

    public String getTranslation() {
        return Translation;
    }

    public String getMv() {
        return mv;
    }

    public String getSp() {
        return sp;
    }

    public String getMk() {
        return mk;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getCouplet() {
        return couplet;
    }

    public String getTransliteration1() {
        return transliteration1;
    }

    public String getTransliteration2() {
        return transliteration2;
    }
}