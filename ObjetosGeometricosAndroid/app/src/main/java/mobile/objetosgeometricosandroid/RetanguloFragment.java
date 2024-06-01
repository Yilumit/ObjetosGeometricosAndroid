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

import mobile.objetosgeometricosandroid.controller.IGeometriaController;
import mobile.objetosgeometricosandroid.controller.RetanguloController;
import mobile.objetosgeometricosandroid.model.Retangulo;


public class RetanguloFragment extends Fragment {
    private View view;
    private EditText etBaseRetangulo;
    private EditText etAlturaRetangulo;
    private TextView tvSaidaRetangulo;
    private Button btnAreaRetangulo;
    private Button btnPerimetroRetangulo;
    private RadioButton rbCentimetrosRetangulo;
    private RadioButton rbMetrosRetangulo;
    private String medida;
    private String texto;

    public RetanguloFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_retangulo, container, false);

        etBaseRetangulo = view.findViewById(R.id.etBaseRetangulo);
        etAlturaRetangulo = view.findViewById(R.id.etAlturaRetangulo);
        tvSaidaRetangulo = view.findViewById(R.id.tvSaidaRetangulo);
        btnAreaRetangulo = view.findViewById(R.id.btnAreaRetangulo);
        btnPerimetroRetangulo = view.findViewById(R.id.btnPerimetroRetangulo);
        rbCentimetrosRetangulo = view.findViewById(R.id.rbCentimetrosRetangulo);
        rbCentimetrosRetangulo.setChecked(true);
        rbMetrosRetangulo = view.findViewById(R.id.rbMetrosRetangulo);

        btnAreaRetangulo.setOnClickListener(op -> calcularArea());
        btnPerimetroRetangulo.setOnClickListener(op -> calcularPerimetro());

        return view;
    }

    private void calcularPerimetro() {
        Retangulo retangulo = new Retangulo();
        retangulo.setBase(Float.parseFloat(etBaseRetangulo.getText().toString()));
        retangulo.setAltura(Float.parseFloat(etAlturaRetangulo.getText().toString()));

        IGeometriaController<Retangulo> op = new RetanguloController();

        if (rbCentimetrosRetangulo.isChecked()){
            medida  = "cm";
        } else {
            medida  = "m";
        }
        texto = getString(R.string.perimetro) + " = " + String.valueOf(op.calcularPerimetro(retangulo)) + medida;

        tvSaidaRetangulo.setText(texto);
        limpaCampos();
    }

    private void calcularArea() {
        Retangulo retangulo = new Retangulo();
        retangulo.setBase(Float.parseFloat(etBaseRetangulo.getText().toString()));
        retangulo.setAltura(Float.parseFloat(etAlturaRetangulo.getText().toString()));

        IGeometriaController<Retangulo> op = new RetanguloController();

        if (rbCentimetrosRetangulo.isChecked()){
            medida = getString(R.string.c_quadrado);
        } else {
            medida = getString(R.string.m_quadrado);
        }
        texto = getString(R.string.area) + " = " + String.valueOf(op.calcularArea(retangulo)) + medida;

        tvSaidaRetangulo.setText(texto);
        limpaCampos();
    }

    private void limpaCampos() {
        etBaseRetangulo.setText("");
        etAlturaRetangulo.setText("");
    }
}