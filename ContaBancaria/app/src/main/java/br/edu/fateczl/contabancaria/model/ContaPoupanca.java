package br.edu.fateczl.contabancaria.model;

import br.edu.fateczl.contabancaria.R;

public class ContaPoupanca extends ContaBancaria{
    private int diaRendimento;

    public ContaPoupanca(String cliente, int numConta, float saldo, int diaRendimento) {
        super(cliente, numConta, saldo);
        this.diaRendimento = diaRendimento;
    }

    public float calcularNovoSaldo(float saldo){
        return saldo * 1.0059f;
    }
    @Override
    public float sacar(float qntdSaque) throws Exception{
        if (qntdSaque > saldo){
            throw new Exception("Quantidade Invalida!");
        }
        setSaldo(saldo - qntdSaque);
        return qntdSaque;
    }

    @Override
    public void depositar(float qntdDeposito) {
        setSaldo(saldo+qntdDeposito);
    }
}
