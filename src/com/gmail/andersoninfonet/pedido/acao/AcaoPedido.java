package pedido.acao;

import java.util.ArrayList;
import java.util.List;

import pedido.Pedido;

public class AcaoPedido implements AcaoPedidoSubject {
    
    private List<AcaoAposGerarPedidoObserver> acoes = new ArrayList<>();

    @Override
    public void subscribe(AcaoAposGerarPedidoObserver acao) {
        this.acoes.add(acao);
    }

    @Override
    public void unsubscribe(AcaoAposGerarPedidoObserver acao) {
        this.acoes.remove(acao);
    }

    @Override
    public void execute(Pedido pedido) {
        this.acoes.forEach(a -> a.executarAcao(pedido));
    }
    
}
