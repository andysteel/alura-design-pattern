package pedido.acao;

import pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedidoObserver {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Salvar Pedido do cliente " + pedido.getCliente() + " no banco");
    }
    
}
