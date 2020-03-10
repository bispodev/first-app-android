package com.bispodev.mathquiz.model;

public class Question {

    private String text;
    private double rCorreta;
    private double rIncorreta;


    public Question(String text, double rCorreta, double rIncorreta){
        this.text = text;
        this.rCorreta = rCorreta;
        this.rIncorreta = rIncorreta;
    }

    public String getText() {
        return text;
    }

    public double getrCorreta() {
        return rCorreta;
    }

    public double getrIncorreta() {
        return rIncorreta;
    }
}
