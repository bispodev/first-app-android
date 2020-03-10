package com.bispodev.mathquiz.model;

public class VerifyQuestion {

    public boolean isRCorreta(Question question, double resposta){
        return question.getrCorreta() == resposta;
    }
}
