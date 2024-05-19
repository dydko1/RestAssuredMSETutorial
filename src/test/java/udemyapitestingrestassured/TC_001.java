package udemyapitestingrestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TC_001 {

    String studentEndPoint = "https://thetestingworldapi.com/api/studentsdetails/10278537";

    @Test
    public void validateStudentGetData() {
        Response response = RestAssured.get(studentEndPoint);
        //response.body().prettyPrint();
        //System.out.println(response.getHeaders());
        System.out.println(response.asString());
        System.out.println(response.asPrettyString());
        System.out.println(response.cookies());
    }
}
