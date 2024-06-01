package mobile.objetosgeometricosandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import mobile.objetosgeometricosandroid.controller.CirculoController;
import mobile.objetosgeometricosandroid.controller.IGeometriaController;
import mobile.objetosgeometricosandroid.model.Circulo;


public class CirculoFragment extends Fragment {
    private View view;
    private EditText etRaioCirculo;
    private TextView tvSaidaCirculo;
    private Button btnAreaCirculo;
    private Button btnPerimetroCirculo;
    private RadioButton rbCentimetrosCirculo;
    private RadioButton rbMetrosCirculo;
    private String medida;
    private String texto;

    public CirculoFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_circulo, container, false);

        etRaioCirculo = view.findViewById(R.id.etRaioCirculo);
        tvSaidaCirculo = view.findViewById(R.id.tvSaidaCirculo);
        btnAreaCirculo = view.findViewById(R.id.btnAreaCirculo);
        btnPerimetroCirculo = view.findViewById(R.id.btnPerimetroCirculo);
        rbCentimetrosCirculo = view.findViewById(R.id.rbCentimetrosCirculo);
        rbCentimetrosCirculo.setChecked(true);
        rbMetrosCirculo = view.findViewById(R.id.rbMetrosCirculo);

        btnAreaCirculo.setOnClickListener(op -> calcularArea());
        btnPerimetroCirculo.setOnClickListener(op -> calcularPerimetro());

        return view;
    }

    private void calcularPerimetro() {
        Circulo circulo = new Circulo();
        circulo.setRaio(Float.parseFloat(etRaioCirculo.getText().toString()));

        IGeometriaController<Circulo> op = new CirculoController();
        float perimetro = op.calcularPerimetro(circulo);

        if (rbCentimetrosCirculo.isChecked()){
            medida = "cm";
        } else {
            medida = "m";
        }
        texto = getString(R.string.perimetro) + " = " + String.valueOf(perimetro) + medida;

        tvSaidaCirculo.setText(texto);
        limparCampos();
    }

    private void calcularArea() {
        Circulo circulo = new Circulo();
        circulo.setRaio(Float.parseFloat(etRaioCirculo.getText().toString()));

        IGeometriaController<Circulo> op = new CirculoController();
        float area = op.calcularArea(circulo);

        if (rbCentimetrosCirculo.isChecked()){
            medida = getString(R.string.c_quadrado);
        } else {
            medida = getString(R.string.m_quadrado);
        }
        texto = getString(R.string.area) + " = " + String.valueOf(area) + medida;

        tvSaidaCirculo.setText(texto);
        limparCampos();
    }

    private void limparCampos() {
        etRaioCirculo.setText("");
    }
}