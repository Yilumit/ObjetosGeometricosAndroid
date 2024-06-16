package br.edu.fateczl.projetomedidorcaloricoandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CalcularFragment extends Fragment {
    private View view;
    private EditText etTempoCalcular;
    private TextView tvSaidaCalcular;
    private Button btnCalcularCaloria;
    private Spinner spAtividadesCalcular;

    public CalcularFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calcular, container, false);

        return view;
    }
}