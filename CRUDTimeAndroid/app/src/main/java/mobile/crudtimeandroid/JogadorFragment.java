package mobile.crudtimeandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import mobile.crudtimeandroid.controller.JogadorController;
import mobile.crudtimeandroid.controller.TimeController;
import mobile.crudtimeandroid.model.Jogador;
import mobile.crudtimeandroid.model.Time;
import mobile.crudtimeandroid.persistence.JogadorDao;
import mobile.crudtimeandroid.persistence.TimeDao;


public class JogadorFragment extends Fragment {
    private View view;
    private TextView tvSaidaJogador;
    private EditText etIdJogador, etNomeJogador, etDataNascJogador, etAlturaJogador, etPesoJogador;
    private Spinner spTimeJogador;
    private Button btnBuscarJogador, btnInserirJogador, btnModificarJogador, btnExcluirJogador, btnListarJogador;
    private JogadorController jCont;
    private TimeController tCont;
    private List<Time> times;

    public JogadorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_jogador, container, false);

        tvSaidaJogador = view.findViewById(R.id.tvSaidaJogador);
        tvSaidaJogador.setMovementMethod(new ScrollingMovementMethod());
        etIdJogador = view.findViewById(R.id.etIdJogador);
        etNomeJogador = view.findViewById(R.id.etNomeJogador);
        etDataNascJogador = view.findViewById(R.id.etDataNascJogador);
        etAlturaJogador = view.findViewById(R.id.etAlturaJogador);
        etPesoJogador = view.findViewById(R.id.etPesoJogador);
        btnBuscarJogador = view.findViewById(R.id.btnBuscarJogador);
        btnInserirJogador = view.findViewById(R.id.btnInserirJogador);
        btnModificarJogador = view.findViewById(R.id.btnModificarJogador);
        btnExcluirJogador = view.findViewById(R.id.btnExcluirJogador);
        btnListarJogador = view.findViewById(R.id.btnListarJogador);
        spTimeJogador = view.findViewById(R.id.spTimeJogador);

        jCont = new JogadorController(new JogadorDao(view.getContext()));
        tCont = new TimeController(new TimeDao(view.getContext()));
        preencheSpinner();

        btnInserirJogador.setOnClickListener(op -> inserir());
        btnModificarJogador.setOnClickListener(op -> modificar());
        btnExcluirJogador.setOnClickListener(op -> excluir());
        btnBuscarJogador.setOnClickListener(op -> buscar());
        btnListarJogador.setOnClickListener(op -> listar());

        return view;
    }

    private void inserir() {
        int spPosition = spTimeJogador.getSelectedItemPosition();
        if (spPosition > 0){
            Jogador jogador = montaJogador();
            try {
                jCont.insert(jogador);
                Toast.makeText(view.getContext(), "Inserido com Sucesso", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione um time!", Toast.LENGTH_LONG).show();
        }
    }
    private void modificar() {
        int spPosition = spTimeJogador.getSelectedItemPosition();
        if (spPosition > 0){
            Jogador jogador = montaJogador();
            try {
                jCont.update(jogador);
                Toast.makeText(view.getContext(), "Atualizado com Sucesso", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione um time!", Toast.LENGTH_LONG).show();
        }
    }

    private void excluir() {
        int spPosition = spTimeJogador.getSelectedItemPosition();
        if (spPosition > 0){
            Jogador jogador = montaJogador();
            try {
                jCont.delete(jogador);
                Toast.makeText(view.getContext(), "Excluido com Sucesso", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        }
    }

    private void buscar() {
        Jogador jogador = montaJogador();
        try {
            times = tCont.findAll();
            jogador = jCont.findOne(jogador);
            if (jogador.getNome() != null){
                preencheCampos(jogador);
            } else {
                Toast.makeText(view.getContext(), "Jogador nao Encontrado!", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listar() {
        try {
            List<Jogador> jogadores = jCont.findAll();
            StringBuffer buffer = new StringBuffer();
            for (Jogador j: jogadores){
                buffer.append(j.toString()+"\n");
            }
            tvSaidaJogador.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Jogador montaJogador(){
        Jogador j = new Jogador();
        j.setId(Integer.parseInt(etIdJogador.getText().toString()));
        j.setNome(etNomeJogador.getText().toString());
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dataRecebida = dbFormat.parse(etDataNascJogador.getText().toString());
            j.setDataNasc(dataRecebida);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        j.setPeso(Float.parseFloat(etPesoJogador.getText().toString()));
        j.setAltura(Float.parseFloat(etAlturaJogador.getText().toString()));
        j.setTime((Time) spTimeJogador.getSelectedItem());

        return j;
    }

    private void preencheCampos(Jogador j){
        etIdJogador.setText(String.valueOf(j.getId()));
        etNomeJogador.setText(j.getNome());
        etDataNascJogador.setText(String.valueOf(j.getDataNasc()));
        etAlturaJogador.setText(String.valueOf(j.getAltura()));
        etPesoJogador.setText(String.valueOf(j.getPeso()));

        int cont = 1;
        for(Time t: times){
            if (t.getCodigo() == j.getTime().getCodigo()) {
                spTimeJogador.setSelection(cont);
            } else {
                cont++;
            }
        }
        if (cont > times.size()){
            spTimeJogador.setSelection(0);
        }
    }

    private void limpaCampos(){
        etIdJogador.setText("");
        etNomeJogador.setText("");
        etDataNascJogador.setText("");
        etAlturaJogador.setText("");
        etPesoJogador.setText("");
        spTimeJogador.setSelection(0);
    }

    private void preencheSpinner() {
        Time t0 = new Time();
        t0.setCodigo(0);
        t0.setNome("Selecione um time");
        t0.setCidade("");

        try {
            times = tCont.findAll();
            times.add(0, t0);

            ArrayAdapter ad = new ArrayAdapter(view.getContext(),
                    android.R.layout.simple_spinner_item, times);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spTimeJogador.setAdapter(ad);

        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}