package mobile.cadastro_atletas_android.controller;

import java.util.ArrayList;
import java.util.List;

import mobile.cadastro_atletas_android.model.AtletaOutro;

public class OperacaoOutro implements IOoperacao<AtletaOutro> {
    private List<AtletaOutro> lista;

    public OperacaoOutro(){
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaOutro atletaOutro) {
        lista.add(atletaOutro);
    }

    @Override
    public List<AtletaOutro> listar() {
        return this.lista;
    }
}
