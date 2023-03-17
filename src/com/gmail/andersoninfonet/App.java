import java.math.BigDecimal;

import desconto.CalculadoraDeDescontos;
import http.JavaHttpClient;
import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import imposto.ISS;
import orcamento.ItemOrcamento;
import orcamento.Orcamento;
import orcamento.OrcamentoProxy;
import orcamento.RegistroDeOrcamento;
import pedido.GeraPedido;
import pedido.GeraPedidoHandler;
import pedido.acao.AcaoPedido;
import pedido.acao.EnviarEmailPedido;
import pedido.acao.SalvarPedidoNoBancoDeDados;

public class App {
    public static void main(String[] args) throws Exception {
        //teste strategy
        var orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        var calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcularImposto(orcamento, new ICMS(null)));

        //teste chain of responsability and template method
        var primeiro = new Orcamento();
        primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        var segundo = new Orcamento();
        segundo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));

        var calculadoraDeDesconto = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDesconto.calcular(primeiro));
        System.out.println(calculadoraDeDesconto.calcular(segundo));

        //teste command, observer and facade
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
        var orcamentoAdapter = new Orcamento();
        orcamentoAdapter.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        orcamentoAdapter.aprovar();
        orcamentoAdapter.finalizar();

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());
        registroDeOrcamento.registrar(orcamentoAdapter);

        //teste Decorator
        var orcamentoDecorator = new Orcamento();
        orcamentoDecorator.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        var calculadoraDecorator = new CalculadoraDeImpostos();
        System.out.println(calculadoraDecorator.calcularImposto(orcamentoDecorator, new ICMS(new ISS(null))));

        //teste composite
        var orcamentoAntigo = new Orcamento();
        orcamentoAntigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        orcamentoAntigo.aprovar();
        
        var orcamentoNovo = new Orcamento();
        orcamentoNovo.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        orcamentoNovo.adicionarItem(orcamentoAntigo);

        OrcamentoProxy orcamentoProxy = new OrcamentoProxy(orcamentoNovo);

        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
    }
}
