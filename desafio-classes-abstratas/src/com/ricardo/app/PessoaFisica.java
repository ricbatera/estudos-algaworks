package com.ricardo.app;

public class PessoaFisica extends Pessoa{
    private final static double RECEITA_ANUAL_ISENCAO = 50000;
    private final static double ALIQUOTA_IMPOSTO_RENDA = .20;
    private double receitaAnual;

    public PessoaFisica(String nome, double receitaAnual) {
        super(nome);
        this.receitaAnual = receitaAnual;
    }

    @Override
    public double calcularImpostos() {
        double imposto = 0;
        if(receitaAnual > RECEITA_ANUAL_ISENCAO){
            imposto = receitaAnual * ALIQUOTA_IMPOSTO_RENDA;
        }
        return imposto;
    }

    public double getReceitaAnual() {
        return receitaAnual;
    }
}
