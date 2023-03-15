package orcamento;

public class OrcamentoException extends RuntimeException {
    
    public OrcamentoException(String mensagem) {
        super(mensagem);
    }

    public OrcamentoException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
