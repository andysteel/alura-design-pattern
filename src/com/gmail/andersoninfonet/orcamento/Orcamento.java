package orcamento;

import java.math.BigDecimal;

public class Orcamento {
    
    private BigDecimal valor;
    
    /**
     * @param valor BigDecimal
     */
    public Orcamento(BigDecimal valor) {
        this.valor = valor;
    }


    /**
     * @return the valor BigDecimal
     */
    public BigDecimal getValor() {
        return valor;
    }
    
}
