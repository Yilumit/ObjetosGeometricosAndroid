package br.edu.fateczl.rolardados;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbD4;
    private RadioButton rbD6;
    private RadioButton rbD8;
    private RadioButton rbD10;
    private RadioButton rbD12;
    private RadioButton rbD20;
    private RadioButton rbD100;
    private Spinner spNumDados;
    private TextView tvResultado;


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

        rbD4 = findViewById(R.id.rbD4);
        rbD4.setChecked(true);
        rbD6 = findViewById(R.id.rbD6);
        rbD8 = findViewById(R.id.rbD8);
        rbD10 = findViewById(R.id.rbD10);
        rbD12 = findViewById(R.id.rbD12);
        rbD20 = findViewById(R.id.rbD20);
        rbD100  = findViewById(R.id.rbD100);
        spNumDados  = findViewById(R.id.spNumDados);
        Button btnRolar = findViewById(R.id.btnRolar);
        btnRolar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        
        preencheSpinner();
        btnRolar.setOnClickListener(op -> LancarDados());
    }

    private void LancarDados() {
        Integer numDados = (Integer) spNumDados.getSelectedItem();

        if (rbD4.isChecked()) {
            String stringDado = (String) getText(R.string.d4);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }
        if (rbD6.isChecked()) {
            String stringDado = (String) getText(R.string.d6);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }
        if (rbD8.isChecked()) {
            String stringDado = (String) getText(R.string.d8);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }
        if (rbD10.isChecked()) {
            String stringDado = (String) getText(R.string.d10);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }
        if (rbD12.isChecked()) {
            String stringDado = (String) getText(R.string.d12);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }
        if (rbD20.isChecked()) {
            String stringDado = (String) getText(R.string.d20);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }
        if (rbD100.isChecked()) {
            String stringDado = (String) getText(R.string.d100);
            String[] nomeDado = stringDado.split("D");
            int dado = Integer.parseInt(nomeDado[1]);
            gerarValores(numDados, dado);
        }

    }

    private void gerarValores(Integer numDados, int dado) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < numDados; i++) {
            int valor = (int)(Math.random()*dado+1);
            buffer.append(valor);
            if (i < numDados-1){
                buffer.append(", ");
            }
        }
        String result = getText(R.string.resultado)+" "+buffer.toString();
        tvResultado.setText(result);
    }

    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumDados.setAdapter(adapter);
    }
}