package pedido;

import java.time.LocalDateTime;

import orcamento.Orcamento;

public class Pedido {

    private String cliente;
    private LocalDateTime data;
    private Orcamento orcamento;

    /**
     * @param cliente String
     * @param data LocalDateTime
     * @param orcamento Orcamento
     */
    public Pedido(String cliente, LocalDateTime data, Orcamento orcamento) {
        this.cliente = cliente;
        this.data = data;
        this.orcamento = orcamento;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @return the data
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * @return the orcamento
     */
    public Orcamento getOrcamento() {
        return orcamento;
    }
    
}
