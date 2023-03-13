package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class SemDesconto extends Desconto {

    protected SemDesconto() {
        super(null);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
    
}
