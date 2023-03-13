import java.math.BigDecimal;

import desconto.CalculadoraDeDescontos;
import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import orcamento.Orcamento;

public class App {
    public static void main(String[] args) throws Exception {
        //teste strategy
        var orcamento = new Orcamento(new BigDecimal("100"), 1);
        var calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcularImposto(orcamento, new ICMS()));

        //teste chain of responsability
        var primeiro = new Orcamento(new BigDecimal("100"), 6);
        var segundo = new Orcamento(new BigDecimal("1000"), 1);

        var calculadoraDeDesconto = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDesconto.calcular(primeiro));
        System.out.println(calculadoraDeDesconto.calcular(segundo));
    }
}
