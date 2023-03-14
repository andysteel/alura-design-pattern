package orcamento;

import java.math.BigDecimal;

import orcamento.situacao.EmAnalise;
import orcamento.situacao.SituacaoOrcamento;

public class Orcamento {
    
    private BigDecimal valor;
    private int quantidadeDeItens;
    private SituacaoOrcamento situacaoOrcamento;
    
    /**
     * @param valor BigDecimal
     */
    public Orcamento(BigDecimal valor, int quantidadeDeItens) {
        this.valor = valor;
        this.quantidadeDeItens = quantidadeDeItens;
        this.situacaoOrcamento = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDescontoExtra = this.situacaoOrcamento.calcularValorDescontoExtra(this);

        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar() {
        this.situacaoOrcamento.aprovar(this);
    }

    public void reprovar() {
        this.situacaoOrcamento.reprovar(this);
    }

    public void finalizar() {
        this.situacaoOrcamento.finalizar(this);
    }

    /**
     * @return the valor BigDecimal
     */
    public BigDecimal getValor() {
        return valor;
    }
    
    /**
     * @return the itens
     */
    public int getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    /**
     * @return the situacaoOrcamento
     */
    public SituacaoOrcamento getSituacaoOrcamento() {
        return situacaoOrcamento;
    }

    /**
     * @param situacaoOrcamento the situacaoOrcamento to set
     */
    public void setSituacaoOrcamento(SituacaoOrcamento situacaoOrcamento) {
        this.situacaoOrcamento = situacaoOrcamento;
    }
}
