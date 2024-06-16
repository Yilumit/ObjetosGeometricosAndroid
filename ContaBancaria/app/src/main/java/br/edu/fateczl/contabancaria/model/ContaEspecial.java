package br.edu.fateczl.contabancaria.model;

import br.edu.fateczl.contabancaria.R;

public class ContaEspecial extends ContaBancaria{
    private float limite;

    public ContaEspecial(String cliente, int numConta, float saldo, float limite) {
        super(cliente, numConta, saldo);
        this.limite = limite;
    }

    @Override
    public float sacar(float qntdSaque) throws Exception {
        if (qntdSaque > (saldo+limite)){
            throw new Exception(String.valueOf(R.string.qntd_invalida));
        }
        setSaldo(saldo-qntdSaque);
        return qntdSaque;
    }

    @Override
    public void depositar(float qntdDeposito) {
        setSaldo(saldo+qntdDeposito);
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
}
