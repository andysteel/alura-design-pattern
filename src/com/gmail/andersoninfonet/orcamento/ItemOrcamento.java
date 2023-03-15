package orcamento;

import java.math.BigDecimal;

public class ItemOrcamento implements Orcavel {
    
    private BigDecimal valor;
    
    /**
     * @param valor BigDecimal
     */
    public ItemOrcamento(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    
}
