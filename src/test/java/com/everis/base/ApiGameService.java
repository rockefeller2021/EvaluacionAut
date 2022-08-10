package com.everis.base;

//import com.everis.base.stepDefinitions.ApiGameSD;
import io.cucumber.java.Before;
        import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import net.thucydides.core.annotations.Step;

        import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiGameService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApiGameService.class);
    static private final String BASE_URL = "https://www.freetogame.com/api/games?platform=pc&category=shooter";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Step("obtiene lista de juegos por platform")
    public void listUser(int id) {

        given().
                spec(requestSpec).
                queryParam("platform", id).
                when().
                get("pc").
                then().
                spec(responseSpec).
                and();

    }

    @Step("obtiene una Categoria")
    public void getUser(String genre) {

        given()
                .spec(requestSpec)
                .pathParams("id", genre).
                when()
                .get("genre/{id}").
                then().
                and();
    }




    public int validateStatusCode(int i) {
        assertThat(lastResponse().statusCode(), is(i));
        return i;
    }



}
