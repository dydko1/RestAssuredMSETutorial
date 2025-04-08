package programautomatycy.StartTest;

import io.restassured.response.Response;
import org.junit.Test;
import programautomatycy.StartTest.serialising.AddItemToCardRequestPojo;

public class K_Serialising {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void serialize() {
        Integer productId = 142;
        Integer quantity = 112;
        Boolean returnCart = true;
        final String endpoint = "/cocart/v1/add-item";

        AddItemToCardRequestPojo addItemToCardRequestPojo = new AddItemToCardRequestPojo(productId, quantity, returnCart);

        Response response = serviceHelper.sendPostRequest(addItemToCardRequestPojo, endpoint);

        response.prettyPrint();

    }
}
