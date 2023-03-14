package pedido;

import java.time.LocalDateTime;

import orcamento.Orcamento;

public class GeraPedidoHandler {

    //construtor com injeção de dependencias: repository, service, etc....
    
    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.valorOrcamento(), dados.quantidadeDeItens());
        Pedido pedido = new Pedido(dados.cliente(), LocalDateTime.now(), orcamento);

        System.out.println("Salvar Pedido do cliente " + pedido.getCliente() + " no banco");
        System.out.println("Enviar email do cliente " + pedido.getCliente());
    }
}
