package br.edu.fateczl.projetomedidorcaloricoandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.projetomedidorcaloricoandroid.controller.CalisteniaController;
import br.edu.fateczl.projetomedidorcaloricoandroid.controller.ExerciciosAcademiaController;
import br.edu.fateczl.projetomedidorcaloricoandroid.model.AtividadeFisica;
import br.edu.fateczl.projetomedidorcaloricoandroid.model.Calistenia;
import br.edu.fateczl.projetomedidorcaloricoandroid.model.ExerciciosAcademia;
import br.edu.fateczl.projetomedidorcaloricoandroid.persistence.CalisteniaDao;
import br.edu.fateczl.projetomedidorcaloricoandroid.persistence.ExerciciosAcademiaDao;


public class AtividadeFragment extends Fragment {

    private View view;
    private EditText etIdAtividade, etNomeAtividade, etMETAtividade, etDescricaoAtividade;
    private TextView tvSaidaAtividade;
    private Spinner spTipoAtividade;
    private Button btnBuscarAtividade, btnInserirAtividade, btnModificarAtividade, btnExcluirAtividade, btnListarAtividade;
    private RadioButton rbCalisteniaAtividade, rbAcademiaAtividade;
    private CalisteniaController aCont;
    private ExerciciosAcademiaController exCont;
    private List<String> atividades;
    private List<AtividadeFisica> listaAtividades;

    public AtividadeFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atividade, container, false);

        etIdAtividade = view.findViewById(R.id.etIdAtivdade);
        etNomeAtividade = view.findViewById(R.id.etNomeAtividade);
        etMETAtividade = view.findViewById(R.id.etMETAtividade);
        etDescricaoAtividade = view.findViewById(R.id.etDescricaoAtividade);
        tvSaidaAtividade = view.findViewById(R.id.tvSaidaAtividade);
        tvSaidaAtividade.setMovementMethod(new ScrollingMovementMethod());
        spTipoAtividade = view.findViewById(R.id.spTipoAtividade);
        btnBuscarAtividade = view.findViewById(R.id.btnBuscarAtividade);
        btnInserirAtividade = view.findViewById(R.id.btnInserirAtividade);
        btnModificarAtividade = view.findViewById(R.id.btnModificarAtividade);
        btnExcluirAtividade = view.findViewById(R.id.btnExcluirAtividade);
        btnListarAtividade = view.findViewById(R.id.btnListarAtividade);

        aCont = new CalisteniaController(new CalisteniaDao(view.getContext()));
        exCont = new ExerciciosAcademiaController(new ExerciciosAcademiaDao(view.getContext()));
        preencheSpinner();

        btnListarAtividade.setOnClickListener(op -> listar());
        btnBuscarAtividade.setOnClickListener(op-> buscar());
        btnExcluirAtividade.setOnClickListener(op -> excluir());
        btnModificarAtividade.setOnClickListener(op -> modificar());
        btnInserirAtividade.setOnClickListener(op -> inserir());

        return view;
    }

    private void inserir() {
        int spPosition = spTipoAtividade.getSelectedItemPosition();

        if (spPosition > 0){
            if (spPosition == 1) {
                Calistenia calistenia = montaCalistenia();
                try {
                    aCont.inserir(calistenia);
                    Toast.makeText(view.getContext(), "Inserido com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
                limpaCampos();
            } else {
                ExerciciosAcademia exerciciosAcademia = montaExerciciosAcademia();
                try {
                    exCont.inserir(exerciciosAcademia);
                    Toast.makeText(view.getContext(), "Inserido com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(view.getContext(), "Selecione um tipo de atividade!", Toast.LENGTH_LONG).show();
        }
    }

    private void limpaCampos() {
        etIdAtividade.setText("");
        etNomeAtividade.setText("");
        etMETAtividade.setText("");
        etDescricaoAtividade.setText("");
        spTipoAtividade.setSelection(0);
    }

    private void modificar() {
        int spPosition = spTipoAtividade.getSelectedItemPosition();

        if (spPosition > 0){
            if (spPosition == 1) {
                Calistenia calistenia = montaCalistenia();
                try {
                    aCont.inserir(calistenia);
                    Toast.makeText(view.getContext(), "Atualizado com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
                limpaCampos();
            } else {
                ExerciciosAcademia exerciciosAcademia = montaExerciciosAcademia();
                try {
                    exCont.inserir(exerciciosAcademia);
                    Toast.makeText(view.getContext(), "Atualizado com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(view.getContext(), "Selecione um tipo de atividade!", Toast.LENGTH_LONG).show();
        }
    }

    private void excluir() {
        int spPosition = spTipoAtividade.getSelectedItemPosition();

        if (spPosition > 0){
            if (spPosition == 1) {
                Calistenia calistenia = montaCalistenia();
                try {
                    aCont.inserir(calistenia);
                    Toast.makeText(view.getContext(), "Excluido com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
                limpaCampos();
            } else {
                ExerciciosAcademia exerciciosAcademia = montaExerciciosAcademia();
                try {
                    exCont.inserir(exerciciosAcademia);
                    Toast.makeText(view.getContext(), "Excluido com Sucesso!", Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(view.getContext(), "Selecione um tipo de atividade!", Toast.LENGTH_LONG).show();
        }
    }

    private void buscar() {
        Calistenia calistenia = montaCalistenia();
        try {
            calistenia = aCont.buscar(calistenia);
            if (calistenia.getNome() != null){
                preencheCampos(calistenia);
            } else {
                Toast.makeText(view.getContext(), "Atividade nao Encontrada!", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void preencheCampos(AtividadeFisica atividadeFisica) {
        etIdAtividade.setText(String.valueOf(atividadeFisica.getCodigo()));
        etNomeAtividade.setText(String.valueOf(atividadeFisica.getNome()));
        etMETAtividade.setText(String.valueOf(atividadeFisica.getMet()));
        etDescricaoAtividade.setText(String.valueOf(atividadeFisica.getDescricao()));
        spTipoAtividade.setSelection(1);
    }

    private void listar() {
//        Calistenia calistenia = new Calistenia();
//        try {
//            listaAtividades = aCont.listar();
//            jogador = jCont.findOne(jogador);
//            if (jogador.getNome() != null){
//                preencheCampos(jogador);
//            } else {
//                Toast.makeText(view.getContext(), "Jogador nao Encontrado!", Toast.LENGTH_LONG).show();
//                limpaCampos();
//            }
//        } catch (SQLException e) {
//            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//        }
    }

    private ExerciciosAcademia montaExerciciosAcademia() {
        ExerciciosAcademia exAcademia = new ExerciciosAcademia();
        exAcademia.setCodigo(Integer.parseInt(etIdAtividade.getText().toString()));
        exAcademia.setNome(etNomeAtividade.getText().toString());
        exAcademia.setMet(Float.parseFloat(etMETAtividade.getText().toString()));
        exAcademia.setDescricao(etDescricaoAtividade.getText().toString());

        return exAcademia;
    }

    private Calistenia montaCalistenia(){
        Calistenia calistenia = new Calistenia();
        calistenia.setCodigo(Integer.parseInt(etIdAtividade.getText().toString()));
        calistenia.setNome(etNomeAtividade.getText().toString());
        calistenia.setMet(Float.parseFloat(etMETAtividade.getText().toString()));
        calistenia.setDescricao(etDescricaoAtividade.getText().toString());

        return calistenia;

    }

    private void preencheSpinner() {
        atividades.add(0, "Selecione um tipo de Atividade:");
        atividades.add(1, "Calistenia");
        atividades.add(2, "Exercicios de Academia");

        ArrayAdapter ad = new ArrayAdapter(view.getContext(),
                android.R.layout.simple_spinner_item, atividades);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoAtividade.setAdapter(ad);
    }
}