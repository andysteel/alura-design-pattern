package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto {


    public DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getQuantidadeDeItens() > 5) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }

        return proximo.calcular(orcamento);
    }
    
}