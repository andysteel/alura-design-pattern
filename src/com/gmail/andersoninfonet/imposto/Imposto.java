package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public abstract class Imposto {

    private Imposto outro;
    
    /**
     * @param outro Imposto
     */
    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    BigDecimal calcular(Orcamento orcamento) {
        var valorImposto = realizarCalculo(orcamento);
        var valorDoOutroImposto = BigDecimal.ZERO;
        if(this.outro !=  null) {
            valorDoOutroImposto = this.outro.realizarCalculo(orcamento);
        }

        return valorImposto.add(valorDoOutroImposto);
    }
}
