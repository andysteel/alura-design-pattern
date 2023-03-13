package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class SemDesconto extends Desconto {

    protected SemDesconto() {
        super(null);
    }

    @Override
    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
       return true;
    }
    
}
