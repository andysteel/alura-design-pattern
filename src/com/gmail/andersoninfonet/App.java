import java.math.BigDecimal;

import desconto.CalculadoraDeDescontos;
import http.JavaHttpClient;
import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import orcamento.Orcamento;
import orcamento.RegistroDeOrcamento;
import pedido.GeraPedido;
import pedido.GeraPedidoHandler;
import pedido.acao.AcaoPedido;
import pedido.acao.EnviarEmailPedido;
import pedido.acao.SalvarPedidoNoBancoDeDados;

public class App {
    public static void main(String[] args) throws Exception {
        //teste strategy
        var orcamento = new Orcamento(new BigDecimal("100"), 1);
        var calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcularImposto(orcamento, new ICMS()));

        //teste chain of responsability and template method
        var primeiro = new Orcamento(new BigDecimal("100"), 6);
        var segundo = new Orcamento(new BigDecimal("1000"), 1);

        var calculadoraDeDesconto = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDesconto.calcular(primeiro));
        System.out.println(calculadoraDeDesconto.calcular(segundo));

        //teste command and observer
        String cliente = "Anderson Dias";
        BigDecimal valorOrcamento = new BigDecimal("600");
        int quantidadeDeItens = 5;

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeDeItens);
        
        var acoes = new AcaoPedido();
        acoes.subscribe(new SalvarPedidoNoBancoDeDados());
        acoes.subscribe(new EnviarEmailPedido());
        GeraPedidoHandler handler = new GeraPedidoHandler(acoes);

        handler.executa(gerador);

        //teste Adapter
        var orcamentoAdapter = new Orcamento(new BigDecimal("500"), 5);
        orcamentoAdapter.aprovar();
        orcamentoAdapter.finalizar();

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());
        registroDeOrcamento.registrar(orcamentoAdapter);
        
    }
}
