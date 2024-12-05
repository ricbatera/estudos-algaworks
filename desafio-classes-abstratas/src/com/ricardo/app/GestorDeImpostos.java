package com.ricardo.app;

public class GestorDeImpostos {
    private static double valorTotalImpostos;

    public static void adicionar(Pessoa... pessoas){
        for(Pessoa pessoa: pessoas){
        valorTotalImpostos += pessoa.calcularImpostos();
        }
    }

    public static double getValorTotalImpostos() {
        return valorTotalImpostos;
    }
}
