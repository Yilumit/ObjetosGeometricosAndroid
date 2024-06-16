package br.edu.fateczl.escolhercombustivelandroid;

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

public class MainActivity extends AppCompatActivity {

    private EditText etLitroGasolina;
    private EditText etLitroEtanol;
    private TextView tvResult;





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

        etLitroGasolina = findViewById(R.id.etLitroGasolina);
        etLitroGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etLitroEtanol = findViewById(R.id.etLitroEtanol);
        etLitroEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btncalcular = findViewById(R.id.btnCalcular);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btncalcular.setOnClickListener(calc -> calcular());

    }

    private void calcular(){
        float gasolina = Float.parseFloat(etLitroGasolina.getText().toString());
        float etanol = Float.parseFloat(etLitroEtanol.getText().toString());
        String compensa;

        if (etanol <= gasolina*0.7) {
            compensa = getString(R.string.combustivel_compensa)+ ": "+getString(R.string.etanol);
        } else {
            compensa = getString(R.string.combustivel_compensa)+ ": "+getString(R.string.gasolina);
        }
        tvResult.setText(compensa);

    }
}