package orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import orcamento.situacao.EmAnalise;
import orcamento.situacao.Finalizado;
import orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {
    
    private BigDecimal valor;
    private SituacaoOrcamento situacaoOrcamento;
    private List<Orcavel> itens;
    
    /**
     * @param valor BigDecimal
     */
    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
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
        return this.itens.size();
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

    public boolean isFinalizado() {
        return this.situacaoOrcamento instanceof Finalizado;
    }

    public void adicionarItem(Orcavel item) {
        this.valor = this.valor.add(item.getValor());
        this.itens.add(item);
    }
}
