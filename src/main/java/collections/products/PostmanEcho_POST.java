package collections.products;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.config;
import static java.lang.System.*;
import static properties.AppConfiguration.appProp;

public class PostmanEcho_POST {

    RequestSpecification request;
    public Response response;

    public static PostmanEcho_POST postmanEcho_POST() {
        return new PostmanEcho_POST();
    }

    public RequestSpecification givenRequestBodyPOST() {
        out.println("Montando request..");
        out.println("url_POST: " + appProp().url_POST());
        out.println("header: Cookie => " + appProp().headerCookie());

        config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", appProp().httpTimeout())
                        .setParam("http.connection.timeout", appProp().httpTimeout()));

        request = RestAssured
                .given()
                .body(appProp().dataRaw())
                .config(config)
                .header("Cookie", appProp().headerCookie(), "Content-Type: application/json");

        return request;
    }

    public Response requestBodyPOST() {
        out.println("Chamando request..");
        response = givenRequestBodyPOST()
                .when()
                .post(appProp().url_POST());
        out.println("Resposta obtida!");
        return response;
    }

    public RequestSpecification givenRequestFormParamPOST() {
        out.println("Montando request..");
        out.println("url_POST: " + appProp().url_POST());
        out.println("header: Cookie => " + appProp().headerCookie());

        config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", appProp().httpTimeout())
                        .setParam("http.connection.timeout", appProp().httpTimeout()));

        request = RestAssured
                .given()
                .contentType("multipart/form-data")
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .config(config)
                .header("Cookie", appProp().headerCookie(), "Content-Type: text/plain");

        return request;
    }

    public Response requestFormParamPOST() {
        out.println("Chamando request..");
        response = givenRequestFormParamPOST()
                .when()
                .post(appProp().url_POST());
        out.println("Resposta obtida!");
        return response;
    }

}
