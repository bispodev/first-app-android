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

public class MainActivity extends AppCompatActivity {

    private ReporQuestion reporQuestion = new ReporQuestion();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Question question = reporQuestion.getReporQuestion().get(0);

        TextView txtQuestion = findViewById(R.id.textView);
        txtQuestion.setText(question.getText());

        Button btnCorreto = findViewById(R.id.btn_correto);
        btnCorreto.setText(String.valueOf(question.getCorreta()));


        Button btnInorreto = findViewById(R.id.btn_incorreto);
        btnInorreto.setText(String.valueOf(question.getIncorreta()));

        Button btnNextQuestion = findViewById(R.id.nextQuestion);
        btnNextQuestion.setText("Próxima pergunta");

        // Listener resp

        View.OnClickListener respostaDoBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String resposta = ((Button) v).getText().toString();
                String mensagem;

                VerifyQuestion verifyQuestion = new VerifyQuestion();
                Question question = reporQuestion.getReporQuestion().get(0);

                if(verifyQuestion.isRespostaCorreta(question, Double.valueOf(resposta))){
                    mensagem = "Parabéns, tu acertou!";
                }else{
                    mensagem = "Aah, tu errou, seu burro :(";
                }

                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_LONG).show();
            }
        };

        btnCorreto.setOnClickListener(respostaDoBtn);
        btnInorreto.setOnClickListener(respostaDoBtn);

    }
}
