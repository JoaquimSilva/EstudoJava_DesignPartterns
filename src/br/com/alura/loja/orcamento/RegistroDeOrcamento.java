package br.com.alura.loja.orcamento;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

import java.net.MalformedURLException;
import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registra(Orcamento orcamento) {
        if (orcamento.isFinalizado()) {
            throw new DomainException("Orcamento não implementado");
        }
        String url = "http://ccc.com";
        Map<String, Object> dados = Map.of("valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens());
        try {
            http.post(url, dados);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
