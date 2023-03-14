package pedido.acao;

import pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedidoObserver {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviar email do cliente " + pedido.getCliente());
    }
    
}
