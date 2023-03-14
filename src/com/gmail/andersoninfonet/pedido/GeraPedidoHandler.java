package pedido;

import java.time.LocalDateTime;

import orcamento.Orcamento;
import pedido.acao.AcaoPedidoSubject;

public class GeraPedidoHandler {

    private AcaoPedidoSubject acoes;

    //construtor com injeção de dependencias: repository, service, etc....
    /**
     * @param acoes
     */
    public GeraPedidoHandler(AcaoPedidoSubject acoes) {
        this.acoes = acoes;
    }
    
    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.valorOrcamento(), dados.quantidadeDeItens());
        Pedido pedido = new Pedido(dados.cliente(), LocalDateTime.now(), orcamento);
        this.acoes.execute(pedido);
    }

}
