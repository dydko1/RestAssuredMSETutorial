package programautomatycy.StartTest;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class FirstTest {
    @Test
    public void firstTest() {
        assertThat(RestAssured.config(),instanceOf(RestAssuredConfig.class));
    }
}
