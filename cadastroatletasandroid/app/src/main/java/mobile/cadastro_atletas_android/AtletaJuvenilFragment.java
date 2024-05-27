package mobile.cadastro_atletas_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import mobile.cadastro_atletas_android.controller.IOoperacao;
import mobile.cadastro_atletas_android.controller.OperacaoJuvenil;
import mobile.cadastro_atletas_android.model.Atleta;
import mobile.cadastro_atletas_android.model.AtletaJuvenil;

public class AtletaJuvenilFragment extends Fragment {

    private View view;
    private EditText etNomeJuvenil;
    private EditText etDataJuvenil;
    private EditText etBairroJuvenil;
    private EditText etAnosPraticaJuvenil;
    private Button btnCadastrarJuvenil;
    public AtletaJuvenilFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);
        etNomeJuvenil = view.findViewById(R.id.etNomeJuvenil);
        etDataJuvenil = view.findViewById(R.id.etDataJuvenil);
        etBairroJuvenil = view.findViewById(R.id.etBairroJuvenil);
        etAnosPraticaJuvenil = view.findViewById(R.id.etAnosPraticaJuvenil);
        btnCadastrarJuvenil = view.findViewById(R.id.btnCadastrarJuvenil);

        btnCadastrarJuvenil.setOnClickListener(op -> cadastrar());
        return view;
    }

    private void cadastrar() {
        AtletaJuvenil aj = new AtletaJuvenil();
        aj.setNome(etNomeJuvenil.getText().toString());
        aj.setDataNascimento(etDataJuvenil.getText().toString());
        aj.setBairro(etBairroJuvenil.getText().toString());
        aj.setAnosPratica(Integer.parseInt(etAnosPraticaJuvenil.getText().toString()));

        IOoperacao<AtletaJuvenil> op = new OperacaoJuvenil();
        op.cadastrar(aj);
        List<AtletaJuvenil> lista = op.listar();
        StringBuffer buffer = new StringBuffer();

        for (AtletaJuvenil atletaJuvenil: lista) {
            buffer.append(atletaJuvenil.toString() + "\n");
        }
        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();

        limparCampos();
    }

    private void limparCampos() {
        etNomeJuvenil.setText("");
        etDataJuvenil.setText("");
        etBairroJuvenil.setText("");
        etAnosPraticaJuvenil.setText("");
    }
}