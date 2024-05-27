package mobile.cadastro_atletas_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import mobile.cadastro_atletas_android.controller.IOoperacao;
import mobile.cadastro_atletas_android.controller.OperacaoOutro;
import mobile.cadastro_atletas_android.model.AtletaOutro;


public class AtletaOutroFragment extends Fragment {

    private View view;
    private EditText etNomeOutro;
    private EditText etDataOutro;
    private EditText etBairroOutro;
    private EditText etAcademiaOutro;
    private EditText etRecordeOutro;
    private Button btnCadastrarOutro;

    public AtletaOutroFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_outro, container, false);

        etNomeOutro = view.findViewById(R.id.etNomeOutro);
        etDataOutro = view.findViewById(R.id.etDataOutro);
        etBairroOutro = view.findViewById(R.id.etBairroOutro);
        etAcademiaOutro = view.findViewById(R.id.etAcademiaOutro);
        etRecordeOutro = view.findViewById(R.id.etRecordeOutro);
        btnCadastrarOutro = view.findViewById(R.id.btnCadastrarOutro);

        btnCadastrarOutro.setOnClickListener(op -> cadastrar());

        return view;
    }

    private void cadastrar() {
        AtletaOutro atletaOutro = new AtletaOutro();
        atletaOutro.setNome(etNomeOutro.getText().toString());
        atletaOutro.setDataNascimento(etDataOutro.getText().toString());
        atletaOutro.setBairro(etBairroOutro.getText().toString());
        atletaOutro.setAcademia(etAcademiaOutro.getText().toString());
        atletaOutro.setRecorde(Float.parseFloat(etRecordeOutro.getText().toString()));

        IOoperacao<AtletaOutro> op = new OperacaoOutro();
        op.cadastrar(atletaOutro);
        List<AtletaOutro> lista = op.listar();
        StringBuffer buffer = new StringBuffer();

        for (AtletaOutro atleta : lista){
            buffer.append(atleta.toString() + "\n");
        }

        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();

        limparCampos();
    }
    private void limparCampos() {
        etNomeOutro.setText("");
        etDataOutro.setText("");
        etBairroOutro.setText("");
        etAcademiaOutro.setText("");
        etRecordeOutro.setText("");
    }
}