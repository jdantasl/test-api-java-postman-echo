package steps;

import collections.products.PostmanEcho_GET;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import properties.AppConfiguration;
import properties.AppProperties;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class PostmanEcho_GETSteps {

    AppProperties appProperties = AppConfiguration.appProp();
    public String responseBodyAsString;

    @Dado("a url GET do Postman Echo")
    public void Dado_AUrlGetDoPostmanEcho() {
        assertNotNull(appProperties.url_GET());
    }

    @Quando("efetuar a chamada por método GET")
    public void Quando_EfetuarAChamadaPorMetodoGet() {
        responseBodyAsString = PostmanEcho_GET.postmanEcho_GET().requestGET().asString();
        System.out.println("responseBodyAsString: " + responseBodyAsString);
    }

    @Então("a resposta deve conter o elemento {string} com conteúdo {string} e {string}")
    public void Entao_ARespostaDeveConterElementoJson(String el0, String el1, String el2) {
        assertTrue(responseBodyAsString.contains(el0));
        assertTrue(responseBodyAsString.contains(el1));
        assertTrue(responseBodyAsString.contains(el2));
        System.out.println("Finalizando..");
        System.out.println(" ");
    }

}
