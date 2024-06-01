package mobile.objetosgeometricosandroid.model;

import androidx.annotation.NonNull;

public class Circulo {
    private float raio;

    public Circulo() {
        super();
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @NonNull
    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                '}';
    }
}
