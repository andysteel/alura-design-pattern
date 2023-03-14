package pedido.acao;

import java.util.ArrayList;
import java.util.List;

import pedido.Pedido;

public class AcaoPedidoSubject {
    
    private List<AcaoAposGerarPedidoObserver> acoes = new ArrayList<>();

    public  void subscribe(AcaoAposGerarPedidoObserver acao) {
        this.acoes.add(acao);
    }

    public void unsubscribe(AcaoAposGerarPedidoObserver acao) {
        this.acoes.remove(acao);
    }

    public void execute(Pedido pedido) {
        this.acoes.forEach(a -> a.executarAcao(pedido));
    }
}
