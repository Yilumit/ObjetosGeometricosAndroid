package br.edu.fateczl.contabancaria;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

import br.edu.fateczl.contabancaria.model.ContaBancaria;
import br.edu.fateczl.contabancaria.model.ContaEspecial;
import br.edu.fateczl.contabancaria.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbPoupanca;
    private RadioButton rbEspecial;
    private EditText etNome;
    private EditText etNumConta;
    private EditText etSaldo;
    private EditText etDiaRendimento;
    private Spinner spFuncao;
    private TextView tvOperacao;
    private TextView tvNome;
    private TextView tvNumConta;
    private TextView tvSaldo;
    private TextView tvTipoConta;
    private ContaBancaria conta;
    private final List<String> lista = new ArrayList<>();

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

        rbPoupanca = findViewById(R.id.rbPoupanca);
        rbPoupanca.setChecked(true);
        rbEspecial = findViewById(R.id.rbEspecial);
        etNome  = findViewById(R.id.etNome);
        etNumConta  = findViewById(R.id.etNumConta);
        etSaldo = findViewById(R.id.etSaldo);
        etDiaRendimento= findViewById(R.id.etDiaRendimento);
        spFuncao = findViewById(R.id.spFuncao);
        tvNome  = findViewById(R.id.tvNome  );
        tvNumConta = findViewById(R.id.tvNumConta);
        tvSaldo = findViewById(R.id.tvSaldo);
        tvTipoConta = findViewById(R.id.tvTipoConta);
        Button btnRealizar = findViewById(R.id.btnRealizar);

        preencherSpinner();
        spFuncao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                etNumConta.setEnabled(!spFuncao.getSelectedItem().equals("Criar Conta")); //Habilita o EditText caso o item selicionado não seja o de Criar Conta

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        rbEspecial.setOnClickListener(v -> {
            etDiaRendimento.setEnabled(!rbEspecial.isChecked());
            lista.remove("Calcular Rendimento");
        });
        rbPoupanca.setOnClickListener(v -> {
            etDiaRendimento.setEnabled(rbPoupanca.isChecked());
            lista.add("Calcular Rendimento");
        });


        btnRealizar.setOnClickListener(op -> realizarOperacao());

    }

    private void realizarOperacao() {
        String cliente = etNome.getText().toString();
        float valor = Float.parseFloat(etSaldo.getText().toString());
        int numConta = (int) (Math.random()*5000+1001);

        String funcao = spFuncao.getSelectedItem().toString();

        switch (funcao){
            case "Criar Conta":
                if (rbPoupanca.isChecked()){
                    int diaRendimento = Integer.parseInt(etDiaRendimento.getText().toString());

                    conta = new ContaPoupanca(cliente,numConta,valor,diaRendimento);
                }
                if (rbEspecial.isChecked()){
                    float limite = 600;
                    conta = new ContaEspecial(cliente,numConta,valor,limite);
                }
                mostrarDados(conta);
                break;
            case "Sacar":

                break;
            case "Depositar":
                break;
            case "Mostrar Dados":
                break;
            default:
                break;
        }

    }

    private void mostrarDados(ContaBancaria conta) {
        String titular = getText(R.string.nome_titular) + ": "+ conta.getCliente();
        String numero = getText(R.string.numero_conta) + ": " + conta.getNumConta();
        String saldo = getText(R.string.saldo) + ": " + conta.getSaldo();
        String tipoConta = conta.getClass().getSimpleName();
        tvNome.setText(titular);
        tvNumConta.setText(numero);
        tvSaldo.setText(saldo);
        tvTipoConta.setText(tipoConta);
    }

    private void preencherSpinner() {

        lista.add("Criar Conta");
        lista.add("Sacar");
        lista.add("Depositar");
        lista.add("Mostar Dados");
        lista.add("Calcular Rendimento");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFuncao.setAdapter(adapter);
    }

}