package br.edu.fateczl.calcularequacao;

import static java.lang.Math.sqrt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText txVarA;
    private EditText txVarB;
    private EditText txVarC;
    private TextView tvEquacao;
    private TextView tvResul;
    private TextView tvDelta;

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

        txVarA = findViewById(R.id.txVarA);
        txVarB = findViewById(R.id.txVarB);
        txVarC = findViewById(R.id.txVarC);
        tvEquacao = findViewById(R.id.tvEquacao);
        tvResul = findViewById(R.id.tvResul);
        tvDelta = findViewById(R.id.tvDelta);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }
    private void calc(){
        float varA = Float.parseFloat(txVarA.getText().toString());
        float varB = Float.parseFloat(txVarB.getText().toString());
        float varC = Float.parseFloat(txVarC.getText().toString());
        String equacao = varA +"x²"+varB+"x"+varC+"=0";
        tvEquacao.setText(equacao);

        float delta = (varB*varB)-(4*varA*varC);
        String del = getString(R.string.delta)+": "+delta;
        tvDelta.setText(del);


        if (delta<0){
            String res = getString(R.string.n_tem);
            tvResul.setText(res);
        } else {
            double x1 = ((-varB + sqrt(delta)) /(2*varA));
            if (delta==0){
                String res = getString(R.string.result)+" :"+x1;
                tvResul.setText(res);
            } else {
                double x2 = ((-varB - sqrt(delta))/(2*varA));
                String res = getString(R.string.result)+" :"+x1+ " e "+x2;
                tvResul.setText(res);

            }
        }
        txVarA.setText("");
        txVarB.setText("");
        txVarC.setText("");

    }
}