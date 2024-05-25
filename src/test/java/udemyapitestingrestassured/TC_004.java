package udemyapitestingrestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_004 {

    String studentEndPoint = "https://thetestingworldapi.com/api/studentsdetails/10280273";
    String studentData = "{\n" +
            "    \"id\": 10280273,\n" +
            "    \"first_name\": \"Miro555\",\n" +
            "    \"middle_name\": \"Leszek1111xxxxxxxxxxxxx\",\n" +
            "    \"last_name\": \"dydko\",\n" +
            "    \"date_of_birth\": \"sample string 5\"\n" +
            "}";

    @Test
    public void updateNewStudent() {
        RequestSpecification putRequestSpecification = RestAssured.given();
        putRequestSpecification.header("content-type", "application/json");
        putRequestSpecification.body(studentData);
        Response putResponse = putRequestSpecification.put(studentEndPoint);

        System.out.println(putResponse.getStatusCode());
        System.out.println(putResponse.asPrettyString());

    }
}