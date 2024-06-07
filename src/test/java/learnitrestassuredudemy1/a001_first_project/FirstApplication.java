package learnitrestassuredudemy1.a001_first_project;

import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class FirstApplication {

    @Test
    public void getGoogle(){
        given().log().all()
                .baseUri("https://google.pl")
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
