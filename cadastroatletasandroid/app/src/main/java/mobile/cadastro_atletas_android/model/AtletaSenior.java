package mobile.cadastro_atletas_android.model;

import androidx.annotation.NonNull;

public class AtletaSenior extends Atleta{
    private boolean problemaCardiaco;

    public AtletaSenior() {
        super();
    }

    public boolean isProblemaCardiaco() {
        return problemaCardiaco;
    }

    public void setProblemaCardiaco(boolean problemaCardiaco) {
        this.problemaCardiaco = problemaCardiaco;
    }

    @NonNull
    @Override
    public String toString() {
        return "AtletaSenior{" +
                "Nome='" +getNome() + '\'' +
                ", Data de Nascimento='" + getDataNascimento() + '\'' +
                ", Bairro='" + getBairro() + '\'' +
                "problemaCardiaco=" + problemaCardiaco +
                '}';
    }
}

