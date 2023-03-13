package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class CalculadoraDeDescontos {
    
    public BigDecimal calcular(Orcamento orcamento) {
        Desconto desconto = new DescontoParaOrcamentoComMaisDeCincoItens(
            new DescontoParaOrcamentoComValorMaiorQueQuinhetos(
                new SemDesconto()
            )
        );
        return desconto.calcular(orcamento);
    }
}
