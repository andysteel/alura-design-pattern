package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class DescontoParaOrcamentoComValorMaiorQueQuinhetos extends Desconto {

    protected DescontoParaOrcamentoComValorMaiorQueQuinhetos(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.2"));
    }

    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
    
}
