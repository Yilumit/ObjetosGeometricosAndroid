package mobile.objetosgeometricosandroid.model;

import androidx.annotation.NonNull;

public class Retangulo {
    private float base;
    private float altura;

    public Retangulo() {
        super();
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @NonNull
    @Override
    public String toString() {
        return "Retangulo{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }
}
