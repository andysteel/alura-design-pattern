package http;

import java.io.IOException;
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
                                .header(url, url)
                                .POST(HttpRequest.BodyPublishers.ofString(url))
                                .build();
                                
        try {
            client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OrcamentoException("Erro ao enviar requisição HTTP", e);
        }
    }
    
}
