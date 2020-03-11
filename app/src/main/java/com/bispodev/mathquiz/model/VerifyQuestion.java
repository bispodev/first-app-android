package com.bispodev.mathquiz.model;

public class VerifyQuestion {

    public boolean isRespostaCorreta(Question question, double resposta){
        return question.getCorreta() == resposta;
    }
}
