package mobile.cadastro_atletas_android.model;

import androidx.annotation.NonNull;

public class AtletaOutro extends Atleta{
    private String academia;
    private float recorde; //em segundos

    public AtletaOutro() {
        super();
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public float getRecorde() {
        return recorde;
    }

    public void setRecorde(float recorde) {
        this.recorde = recorde;
    }

    @NonNull
    @Override
    public String toString() {
        return "AtletaOutro{" +
                "Academia='" + academia + '\'' +
                "Nome='" + getNome() + '\'' +
                "Data de Nascimento='" + getDataNascimento() + '\'' +
                "Bairro+'" + getBairro() + '\'' +
                ", Recorde=" + recorde +
                '}';
    }
}
