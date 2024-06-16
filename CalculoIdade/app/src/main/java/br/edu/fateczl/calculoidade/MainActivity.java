package br.edu.fateczl.calculoidade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private EditText etDia;
    private EditText etMes;
    private EditText etAno;
    private TextView tvIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etDia = findViewById(R.id.etDia);
        etDia.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etMes = findViewById(R.id.etMes);
        etMes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etAno = findViewById(R.id.etAno);
        etAno.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvIdade = findViewById(R.id.tvIdade);
        tvIdade.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(click0 -> calcular());
    }
    private void calcular() {
        int diaNascimento = Integer.parseInt(etDia.getText().toString());
        int mesNascimento = Integer.parseInt(etMes.getText().toString());
        int anoNascimento = Integer.parseInt(etAno.getText().toString());
        int diaAtual = LocalDate.now().getDayOfMonth();
        int mesAtual = LocalDate.now().getMonthValue();
        int anoAtual = LocalDate.now().getYear();

        int idadeAno = anoAtual - anoNascimento;  //Idade em anos
        int idadeMes = 0;   //Idade em meses
        int idadeDia;   //Idade em dias

        //Verificacao da idade
        if (mesAtual < mesNascimento) {
            idadeAno--;
            idadeMes = 12 - (mesNascimento-mesAtual);
            if (diaAtual < diaNascimento) {
                idadeMes = idadeMes - 1;
            }
        } else if (mesAtual == mesNascimento) {
            if (diaAtual < diaNascimento) {
                idadeAno--;
            }
        } else if (mesAtual > mesNascimento) {
            idadeMes = (mesAtual - mesNascimento);
            if (diaAtual < diaNascimento) {
                idadeMes = idadeMes -1;
            }
        }
        int tamanho = LocalDate.now().minusMonths(1).lengthOfMonth();
        if (diaAtual > diaNascimento) {
            idadeDia = diaAtual - diaNascimento;
        }else {
            idadeDia = (tamanho - diaNascimento) + diaAtual;
        }

        exibir(idadeDia,idadeMes,idadeAno);
    }

    private void exibir(int idadeDia, int idadeMes, int idadeAno) {
        String idade = getText(R.string.idade)+": "+idadeAno+" "+getText(R.string.anos)+", "
                +idadeMes+" "+getText(R.string.meses)+", "+idadeDia+" "+getText(R.string.dias);
        tvIdade.setText(idade);
    }

// private boolean isBissexto(int ano) {
//        if (ano % 4==0) {
//            if (ano % 100!=0) { //Ano bissexto
//                return true;
//            }
//        } else if (ano % 400==0){ //Ano bissexto
//            return true;
//        }
//        return  false;
//    }
}