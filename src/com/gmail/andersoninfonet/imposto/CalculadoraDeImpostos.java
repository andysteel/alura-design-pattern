package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class CalculadoraDeImpostos {
    
    public BigDecimal calcularImposto(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }
}
