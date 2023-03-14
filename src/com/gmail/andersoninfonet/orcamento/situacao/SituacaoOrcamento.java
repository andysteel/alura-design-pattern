package orcamento.situacao;

import java.math.BigDecimal;

import orcamento.Orcamento;

public abstract class SituacaoOrcamento {

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
    
    public void aprovar(Orcamento orcamento) {
        throw new StateException("Orçamento não pode ser aprovado.");
    }

    public void reprovar(Orcamento orcamento) {
        throw new StateException("Orçamento não pode ser reprovado.");
    }

    public void finalizar(Orcamento orcamento) {
        throw new StateException("Orçamento não pode ser finalizado.");
    }
}
