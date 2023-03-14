package pedido.acao;

import pedido.Pedido;

public interface AcaoAposGerarPedidoObserver {
    
    public void executarAcao(Pedido pedido);
}
