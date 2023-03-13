package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class DescontoParaOrcamentoComValorMaiorQueQuinhetos extends Desconto {

    protected DescontoParaOrcamentoComValorMaiorQueQuinhetos(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal("0.2"));
        }
        return proximo.calcular(orcamento);
    }
    
}
