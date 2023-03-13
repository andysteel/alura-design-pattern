package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class ICMS implements Imposto {

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
    
}
