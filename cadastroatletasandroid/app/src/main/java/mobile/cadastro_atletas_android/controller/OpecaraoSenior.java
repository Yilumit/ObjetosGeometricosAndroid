package mobile.cadastro_atletas_android.controller;

import java.util.ArrayList;
import java.util.List;

import mobile.cadastro_atletas_android.model.AtletaSenior;

public class OpecaraoSenior implements IOoperacao<AtletaSenior> {
    private List<AtletaSenior> lista;

    public OpecaraoSenior(){
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaSenior atletaSenior) {
        lista.add(atletaSenior);
    }

    @Override
    public List<AtletaSenior> listar() {
        return this.lista;
    }
}
