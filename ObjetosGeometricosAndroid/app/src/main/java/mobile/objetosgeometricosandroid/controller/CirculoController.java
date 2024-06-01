package mobile.objetosgeometricosandroid.controller;

import static java.lang.Math.pow;

import mobile.objetosgeometricosandroid.model.Circulo;

public class CirculoController implements IGeometriaController<Circulo> {
    private final float PI;

    public CirculoController() {
        this.PI = 3.14f;
    }

    @Override
    public float calcularArea(Circulo circulo) {
        return (float) (PI * pow(circulo.getRaio(), 2));
    }

    @Override
    public float calcularPerimetro(Circulo circulo) {
        return 2 * PI * circulo.getRaio();
    }
}
