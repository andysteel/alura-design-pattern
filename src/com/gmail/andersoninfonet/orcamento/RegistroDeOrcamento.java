package orcamento;

import java.util.Map;

import http.HttpAdapter;
import orcamento.situacao.StateException;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    /**
     * @param http HttpAdapter
     */
    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }



    public void registrar(Orcamento orcamento) {
        if(!orcamento.isFinalizado()) {
            throw new StateException("Orçamento não finalizado.");
        }

        var url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
            "valor", orcamento.getValor(),
            "quantidadeItens", orcamento.getQuantidadeDeItens());

        try {
            http.post(url, dados);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
