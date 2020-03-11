package com.bispodev.mathquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bispodev.mathquiz.R;
import com.bispodev.mathquiz.model.Question;
import com.bispodev.mathquiz.model.ReporQuestion;
import com.bispodev.mathquiz.model.VerifyQuestion;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ReporQuestion reporQuestion = new ReporQuestion();
    private int indexQuestion = 0;
    private TextView txtQuestion;
    private Button btnCorreto, btnInorreto, btnNextQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Texts(indexQuestion);

        // Listener resp
        View.OnClickListener respostaDoBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String resposta = ((Button) v).getText().toString();
                String mensagem;

                VerifyQuestion verifyQuestion = new VerifyQuestion();
                Question question = reporQuestion.getReporQuestion().get(indexQuestion);

                if(verifyQuestion.isRespostaCorreta(question, Double.valueOf(resposta))){
                    mensagem = "Parabéns, tu acertou!";
                    if(reporQuestion.getReporQuestion().size() >= indexQuestion){
                        indexQuestion ++;
                        nextQuestion();
                    }else{
                        indexQuestion = 0;
                    }
                }else{
                    mensagem = "Aah, tu errou, seu burro :(";
                }

                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener nextQuestion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        };

        btnCorreto.setOnClickListener(respostaDoBtn);
        btnInorreto.setOnClickListener(respostaDoBtn);
        btnNextQuestion.setOnClickListener(nextQuestion);

    }

    private void nextQuestion(){
        indexQuestion ++;
        if(reporQuestion.getReporQuestion().size() <= indexQuestion){
            indexQuestion = 0;
        }
        Texts(indexQuestion);
    };

    private void Texts(int index){
        Question question = reporQuestion.getReporQuestion().get(index);

        final Locale locale = new Locale("pt", "BR");

        txtQuestion= findViewById(R.id.textView);
        txtQuestion.setText(question.getText());

        btnCorreto= findViewById(R.id.btn_correto);
        String respCorrect = String.format(locale, "%.2f",question.getCorreta());
        btnCorreto.setText(respCorrect);

        btnInorreto = findViewById(R.id.btn_incorreto);
        String respIncorrect = String.format(locale, "%.2f",question.getIncorreta());
        btnInorreto.setText(respIncorrect);

        btnNextQuestion = findViewById(R.id.nextQuestion);
    };
}
