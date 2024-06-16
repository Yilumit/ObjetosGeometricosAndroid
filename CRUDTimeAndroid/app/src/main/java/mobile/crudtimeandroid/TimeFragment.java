package mobile.crudtimeandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import mobile.crudtimeandroid.controller.TimeController;
import mobile.crudtimeandroid.model.Time;
import mobile.crudtimeandroid.persistence.TimeDao;


public class TimeFragment extends Fragment {
    private View view;
    private TextView tvSaidaTime;
    private EditText etCodigoTime, etNomeTime, etCidadeTime;
    private Button btnInserirTime, btnModificarTime, btnExcluirTime, btnListarTime, btnBuscarTime;
    private TimeController tCont;

    public TimeFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time, container, false);

        tvSaidaTime = view.findViewById(R.id.tvSaidaTime);
        tvSaidaTime.setMovementMethod(new ScrollingMovementMethod());
        etCodigoTime = view.findViewById(R.id.etCodigoTime);
        etNomeTime = view.findViewById(R.id.etNomeTime);
        etCidadeTime = view.findViewById(R.id.etCidadeTime);
        btnBuscarTime = view.findViewById(R.id.btnBuscarTime);
        btnInserirTime = view.findViewById(R.id.btnInserirTime);
        btnModificarTime = view.findViewById(R.id.btnModificarTime);
        btnExcluirTime = view.findViewById(R.id.btnExcluirTime);
        btnListarTime = view.findViewById(R.id.btnListarTime);

        tCont = new TimeController(new TimeDao(view.getContext()));

        btnInserirTime.setOnClickListener(op -> inserir());
        btnModificarTime.setOnClickListener(op -> modificar());
        btnExcluirTime.setOnClickListener(op -> excluir());
        btnBuscarTime.setOnClickListener(op -> buscar());
        btnListarTime.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        Time time = montaTime();
        try {
            tCont.insert(time);
            Toast.makeText(view.getContext(), "Inserido com Sucesso", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void modificar() {
        Time time = montaTime();
        try {
            tCont.update(time);
            Toast.makeText(view.getContext(), "Atualizado com Sucesso", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void excluir() {
        Time time = montaTime();
        try {
            tCont.delete(time);
            Toast.makeText(view.getContext(), "Excluido com Sucesso", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void buscar() {
        Time time = montaTime();
        try {
            time = tCont.findOne(time);
            if (time.getNome() != null){
                preencheCampos(time);
            } else {
                Toast.makeText(view.getContext(),"Time nao encontrado!", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Time> times = tCont.findAll();
            StringBuffer buffer = new StringBuffer();
            for (Time t: times){
                buffer.append(t.toString()+"\n");
            }
            tvSaidaTime.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    private Time montaTime(){
        Time t = new Time();
        t.setCodigo(Integer.parseInt(etCodigoTime.getText().toString()));
        t.setNome(etNomeTime.getText().toString());
        t.setCidade(etCidadeTime.getText().toString());

        return  t;
    }

    private void preencheCampos(Time t){
        etCodigoTime.setText(String.valueOf(t.getCodigo()));
        etNomeTime.setText(t.getNome());
        etCidadeTime.setText(t.getCidade());
    }

    private void limpaCampos(){
        etCodigoTime.setText("");
        etNomeTime.setText("");
        etCidadeTime.setText("");
    }

}