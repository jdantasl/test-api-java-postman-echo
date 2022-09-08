package steps;

import collections.products.PostmanEcho_POST;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import properties.AppConfiguration;
import properties.AppProperties;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class PostmanEcho_POSTSteps {

    AppProperties appProperties = AppConfiguration.appProp();
    public String responseBodyAsString;

    @Dado("a url POST do Postman Echo")
    public void Dado_AUrlPostDoPostmanEcho() {
        assertNotNull(appProperties.url_POST());
    }

    @Quando("efetuar a chamada por método POST com dados via body")
    public void Quando_EfetuarAChamadaPorMetodoPostViaBody() {
        responseBodyAsString = PostmanEcho_POST.postmanEcho_POST().requestBodyPOST().asString();
        System.out.println("responseBodyAsString: " + responseBodyAsString);
    }

    @Quando("efetuar a chamada por método POST com dados via formParam")
    public void Quando_EfetuarAChamadaPorMetodoPostViaFormParam() {
        responseBodyAsString = PostmanEcho_POST.postmanEcho_POST().requestFormParamPOST().asString();
        System.out.println("responseBodyAsString: " + responseBodyAsString);
    }

    @Então("a resposta deve conter o elemento data com conteúdo {string} e {string}")
    public void Entao_ARespostaDeveConterElementoData(String el1, String el2) {
        assertTrue(responseBodyAsString.contains("data"));
        assertTrue(responseBodyAsString.contains(el1));
        assertTrue(responseBodyAsString.contains(el2));
        System.out.println("Finalizando..");
        System.out.println(" ");
    }

    @Então("a resposta deve conter o elemento form com conteúdo {string} e {string}")
    public void Entao_ARespostaDeveConterElementoForm(String el1, String el2) {
        assertTrue(responseBodyAsString.contains("form"));
        assertTrue(responseBodyAsString.contains(el1));
        assertTrue(responseBodyAsString.contains(el2));
        System.out.println("Finalizando..");
        System.out.println(" ");
    }

}
