package mobile.cadastro_atletas_android.model;

import androidx.annotation.NonNull;

public class AtletaJuvenil extends Atleta {
    private int anosPratica;

    public AtletaJuvenil() {
        super();
    }

    public int getAnosPratica() {
        return anosPratica;
    }

    public void setAnosPratica(int anosPratica) {
        this.anosPratica = anosPratica;
    }

    @NonNull
    @Override
    public String toString() {
        return "AtletaJuvenil{" +
                "Nome='" +getNome() + '\'' +
                ", Data de Nascimento='" + getDataNascimento() + '\'' +
                ", Bairro='" + getBairro() + '\'' +
                ", Anos de Pratica=" + anosPratica +
                '}';
    }
}
