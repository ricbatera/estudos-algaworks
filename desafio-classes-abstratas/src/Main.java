import com.ricardo.app.*;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {

        var ricardo = new PessoaFisica("Ricardo Alves Roberto", 65000);
        var silvana = new PessoaFisica("Silvana da Silva Roberto", 50000);
        var telTelecomunicacoes = new EmpresaSimples("Tel Telecomunicações", 2000000, 300000);
        var telTelecomunicacoes2 = new EmpresaLucroReal("Tel Telecomunicações", 2000000, 300000);
        var rdrTech = new EmpresaSimples("RDR Tech", 2500000, 10000);
        var rdrTech2 = new EmpresaLucroReal("RDR Tech", 2500000, 10000);
        var pequena = new EmpresaSimples("Empresa Pequena", 1100, 100);
        var pequena2 = new EmpresaLucroReal("Empresa Pequena", 1100, 100);


        imprimeResumoImpostos(ricardo, silvana, telTelecomunicacoes, telTelecomunicacoes2, rdrTech2, rdrTech2, pequena, pequena2);
        GestorDeImpostos.adicionar(ricardo, silvana, telTelecomunicacoes, telTelecomunicacoes2, rdrTech2, rdrTech2, pequena, pequena2);
        var totalImpostos = NumberFormat.getCurrencyInstance().format(GestorDeImpostos.getValorTotalImpostos());
        System.out.printf("Total de Imposto Arrecadado: %s", totalImpostos);
    }

    private static void imprimeResumoImpostos(Pessoa... pessoas){
        for (Pessoa pesssoa: pessoas){
            var imposto = NumberFormat.getCurrencyInstance().format(pesssoa.calcularImpostos());
            System.out.printf("Imposto devido por: %s %s%n", pesssoa.getNome(), imposto);
            if(pesssoa instanceof PessoaJuridica) {
                var lucro = NumberFormat.getCurrencyInstance().format(((PessoaJuridica) pesssoa).getLucroAnual());
                var lucroLiquido = NumberFormat.getCurrencyInstance().format((((PessoaJuridica) pesssoa).getLucroAnual() - pesssoa.calcularImpostos()));
                System.out.printf("\tLucro bruto da Empresa: %s%n", lucro);
                System.out.printf("\tLucro líquido da Empresa: %s%n", lucroLiquido);
            }
            System.out.println("-------------------------------------------------");
        }
    }
}