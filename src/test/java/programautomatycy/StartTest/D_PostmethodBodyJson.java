package programautomatycy.StartTest;

import org.json.JSONObject;
import org.junit.Test;

public class D_PostmethodBodyJson {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    private final String endpoint = "/cocart/v1/add-item";

    @Test
    public void addItemByJsonObject() {
        JSONObject body = new JSONObject();
        body.put("product_id", 140);
        body.put("quantity", 59);
        body.put("return_cart", true);

        serviceHelper.sendPostRequest(body.toString(), endpoint);
    }

}