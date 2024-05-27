
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
import mobile.cadastro_atletas_android.controller.OpecaraoSenior;
import mobile.cadastro_atletas_android.model.AtletaSenior;


public class AtletaSeniorFragment extends Fragment {

    private View view;
    private EditText etNomeSenior;
    private EditText etDataSenior;
    private EditText etBairroSenior;
    private CheckBox cbProblemasSenior;
    private Button btnCadastrarSenior;

    public AtletaSeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_senior, container, false);
        etNomeSenior = view.findViewById(R.id.etNomeSenior);
        etDataSenior = view.findViewById(R.id.etDataSenior);
        etBairroSenior = view.findViewById(R.id.etBairroSenior);
        cbProblemasSenior = view.findViewById(R.id.cbProblemasSenior);
        btnCadastrarSenior = view.findViewById(R.id.btnCadastrarSenior);

        btnCadastrarSenior.setOnClickListener(op -> cadastrar());

        return view;
    }

    private void cadastrar() {
        AtletaSenior atletaSenior = new AtletaSenior();
        atletaSenior.setNome(etNomeSenior.getText().toString());
        atletaSenior.setDataNascimento(etDataSenior.getText().toString());
        atletaSenior.setBairro(etBairroSenior.getText().toString());
        atletaSenior.setProblemaCardiaco(cbProblemasSenior.isChecked());

        IOoperacao<AtletaSenior> op = new OpecaraoSenior();
        op.cadastrar(atletaSenior);
        List<AtletaSenior> lista = op.listar();
        StringBuffer buffer = new StringBuffer();

        for (AtletaSenior atleta : lista){
            buffer.append(atleta.toString() + "\n");
        }

        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();

        limparCampos();
    }
    private void limparCampos() {
        etNomeSenior.setText("");
        etDataSenior.setText("");
        etBairroSenior.setText("");
        cbProblemasSenior.setChecked(false);
    }
}