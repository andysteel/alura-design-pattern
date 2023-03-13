import java.math.BigDecimal;

import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import orcamento.Orcamento;

public class App {
    public static void main(String[] args) throws Exception {
        var orcamento = new Orcamento(new BigDecimal("100"));
        var calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcularImposto(orcamento, new ICMS()));
    }
}
