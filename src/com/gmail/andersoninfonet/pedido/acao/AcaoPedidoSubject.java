package pedido.acao;

import pedido.Pedido;

public interface AcaoPedidoSubject {

    public  void subscribe(AcaoAposGerarPedidoObserver acao);

    public void unsubscribe(AcaoAposGerarPedidoObserver acao);

    public void execute(Pedido pedido);
}
