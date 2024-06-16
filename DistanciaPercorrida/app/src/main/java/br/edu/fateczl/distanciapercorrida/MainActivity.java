package br.edu.fateczl.distanciapercorrida;

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

    private EditText etConsumoMedio;
    private EditText etQntdCombustivel;
    private TextView tvTitulo;
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

        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etConsumoMedio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etQntdCombustivel = findViewById(R.id.etQntdCombustivel);
        etQntdCombustivel.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvTitulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(calc -> calcular());
    }

    private void calcular() {
        float consumo = Float.parseFloat(etConsumoMedio.getText().toString());
        float combustivel = Float.parseFloat(etQntdCombustivel.getText().toString());
        float distanciaPercorrida = (consumo * combustivel)*1000;

        String resultado = getString(R.string.distancia)+" "+distanciaPercorrida+" M";
        tvResultado.setText(resultado);

    }


}