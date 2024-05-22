package udemyapitestingrestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC_002 {

    String studentEndPoint = "https://thetestingworldapi.com/api/studentsdetails";

    @Test
    public void addNewStudent() {
        RequestSpecification postRequest = RestAssured
                .given()
                .baseUri(studentEndPoint);

        postRequest.body("{\n" +
                "        \"first_name\": \"Miro111\",\n" +
                "        \"middle_name\": \"Leszek1111xxxxxxxxxxxxx\",\n" +
                "        \"last_name\": \"dydko\",\n" +
                "        \"date_of_birth\": \"sample string 5\"\n" +
                "    }");
        postRequest.header("content-type", "application/json");

        Response postResponse = postRequest.post();
        System.out.println(postResponse.asPrettyString());
    }
}
