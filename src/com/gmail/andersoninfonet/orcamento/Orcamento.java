package orcamento;

import java.math.BigDecimal;

public class Orcamento {
    
    private BigDecimal valor;
    private int quantidadeDeItens;
    
    /**
     * @param valor BigDecimal
     */
    public Orcamento(BigDecimal valor, int quantidadeDeItens) {
        this.valor = valor;
        this.quantidadeDeItens = quantidadeDeItens;
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
}
