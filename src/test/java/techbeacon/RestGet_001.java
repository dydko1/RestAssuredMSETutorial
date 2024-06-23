package techbeacon;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class RestGet_001 {

    private static final String URI = "http://ergast.com/api/f1/2017/circuits.json";

    @Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

        Response response = given().
                when().
                get(URI);
        //r.prettyPrint();
        response.then()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .header("Content-Length", equalTo("4552"));
    }

    @Test
    public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {

        String originalText = "TestMirooooooooooooooooooo";
        String expectedMd5CheckSum = "b3560aca5979a1e4f8532aa33469cbd4";

        given().
                param("text", originalText).
                when().
                get("http://md5.jsontest.com").
                then().
                assertThat()
                .body("md5", equalTo(expectedMd5CheckSum))
                .body("original", equalTo(originalText));
    }

    @DataProvider(name = "seasonsAndNumberOfRaces")
    public Object[][] createTestDataRecords() {
        return new Object[][]{
                {"2017", 20},
                {"2016", 21},
                {"1966", 9}
        };
    }

    @Test(dataProvider = "seasonsAndNumberOfRaces")
    public void test_NumberOfCircuits_ShouldBe_DataDriven(String season, int numberOfRaces) {

        given().
                pathParam("raceSeason", season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId", hasSize(numberOfRaces));
    }
}