package mobile.crudtimeandroid.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.Date;

public class Jogador {
    private int id;
    private String nome;
    private Date dataNasc;
    private float altura;
    private float peso;
    private Time time;

    public Jogador() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    @NonNull
    @Override
    public String toString() {
        return  id + " - " + nome + " - data de Nascimento=" + dataNasc + " - altura " + altura + " - peso " + peso + " - time " + time;
    }
}
