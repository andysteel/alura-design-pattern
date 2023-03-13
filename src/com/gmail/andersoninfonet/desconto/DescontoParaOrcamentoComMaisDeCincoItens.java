package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto {


    public DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQuantidadeDeItens() > 5;
    }
    
}
