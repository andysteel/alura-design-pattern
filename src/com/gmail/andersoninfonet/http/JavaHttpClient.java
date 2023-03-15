package http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;

import orcamento.OrcamentoException;

public class JavaHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) throws InterruptedException {
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .POST(HttpRequest.BodyPublishers.ofString(url))
                                .build();
                                
        try {
            client.sendAsync(request, BodyHandlers.ofString());
        } catch (Exception e) {
            throw new OrcamentoException("Erro ao enviar requisição HTTP", e);
        }
    }
    
}
