package udemyapitestingrestassured;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_CREATED;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_010_Get_Param {

    private static final String BASE_URL = "https://thetestingworldapi.com/";
    private static final String PATH_1 = "api/technicalskills/794363";
    private static final String PATH_2 = "api/studentsdetails/10280273";
    private static final String PATH_3 = "api/technicalskills/794364";
    private static final String PATH_4 = "api/studentsdetails/10280274";

    @Test
    public void tc010() {
        RequestSpecification requestSpecification = given().baseUri(BASE_URL);

        requestSpecification.basePath(PATH_1);
        Response response = requestSpecification.get();
        response.prettyPrint();
        System.out.println("-----------------------------");
        requestSpecification.basePath(PATH_2);
        response = requestSpecification.get();
        response.prettyPrint();

        requestSpecification.basePath(PATH_3);
        response = requestSpecification.get();
        response.prettyPrint();
        System.out.println("-----------------------------");
        requestSpecification.basePath(PATH_4);
        response = requestSpecification.get();
        response.prettyPrint();


        requestSpecification.baseUri("https://www.onet.pl/");
        requestSpecification.basePath("");
        response = requestSpecification.get();
        response.prettyPrint();
    }
}
