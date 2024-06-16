package br.edu.fateczl.projetomedidorcaloricoandroid.model;

public abstract class AtividadeFisica {
    protected String nome;
    protected int codigo;
    protected float met;
    protected String descricao;


    public AtividadeFisica() {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getMet() {
        return met;
    }

    public void setMet(float MET) {
        this.met = met;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
