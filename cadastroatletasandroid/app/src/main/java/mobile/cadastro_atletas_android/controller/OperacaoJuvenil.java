package mobile.cadastro_atletas_android.controller;

import java.util.ArrayList;
import java.util.List;

import mobile.cadastro_atletas_android.model.AtletaJuvenil;

public class OperacaoJuvenil implements IOoperacao<AtletaJuvenil> {
    private List<AtletaJuvenil> lista;

    public OperacaoJuvenil(){
        this.lista =new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaJuvenil atletaJuvenil) {
        lista.add(atletaJuvenil);
    }

    @Override
    public List<AtletaJuvenil> listar() {
        return this.lista;
    }
}
