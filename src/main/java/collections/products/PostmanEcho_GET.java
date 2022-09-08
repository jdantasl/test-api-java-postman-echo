package collections.products;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.config;
import static java.lang.System.*;
import static properties.AppConfiguration.appProp;

public class PostmanEcho_GET {

    RequestSpecification request;
    public Response response;

    public static PostmanEcho_GET postmanEcho_GET() {
        return new PostmanEcho_GET();
    }

    public RequestSpecification givenRequestGET() {
        out.println("Montando request..");
        out.println("url_GET: " + appProp().url_GET());
        out.println("header: Cookie => " + appProp().headerCookie());

        config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", appProp().httpTimeout())
                        .setParam("http.connection.timeout", appProp().httpTimeout()));

        request = RestAssured.given().config(config).header("Cookie", appProp().headerCookie());
        return request;
    }

    public Response requestGET() {
        out.println("Chamando request..");
        response = givenRequestGET()
                .when()
                .get(appProp().url_GET());
        out.println("Resposta obtida!");
        return response;
    }

}
