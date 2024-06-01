package mobile.objetosgeometricosandroid.controller;

import mobile.objetosgeometricosandroid.model.Retangulo;

public class RetanguloController implements IGeometriaController<Retangulo> {

    public RetanguloController() {
        super();
    }

    @Override
    public float calcularArea(Retangulo retangulo) {
        return retangulo.getBase() * retangulo.getAltura();
    }

    @Override
    public float calcularPerimetro(Retangulo retangulo) {
        return (retangulo.getBase() + retangulo.getAltura()) * 2;
    }
}
