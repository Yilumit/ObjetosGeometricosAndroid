package mobile.cadastro_atletas_android.controller;

import java.util.List;

public interface IOoperacao<T> {
    public void cadastrar(T t);
    public List<T> listar();
}
