package programautomatycy.StartTest;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

public class I_ReadValueFromResponse {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void readCalculateValuesJsonPath() {
        final String endpoint = "/cocart/v1/calculate";
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String subtotal = response.getBody().jsonPath().getString("subtotal");
        Double subtotal_tax = response.getBody().jsonPath().getDouble("subtotal_tax");

        Object cartContentsTaxes = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");
        Map<String, Double> cartContentsTaxesMap = response.getBody().jsonPath().getMap("cart_contents_taxes");
        System.out.println(cartContentsTaxesMap.get("1"));
    }

    @Test
    public void readValueAddItem() {
        final String endpoint2 = "/cocart/v1/add-item";

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint2);

        String jsonString = response.getBody().asString();
        JSONObject jsonObject = new JSONObject(jsonString);
        String key = jsonObject.getString("key");
        Double productId = jsonObject.getDouble("product_id");
        String productName = jsonObject.getString("product_name");

        Double total = jsonObject.getJSONObject("line_tax_data").optJSONObject("total").getDouble("1");
        System.out.println(total);
    }

    @Test
    public void readValueByKey() {
        final String endpoint = "/cocart/v1/add-item";

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", true);

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().asString();
        JSONObject jsonObject = new JSONObject(jsonString);
        String dataHash = jsonObject.getJSONObject("1385974ed5904a438616ff7bdb3f7439").getString("data_hash");
        System.out.println(dataHash);
        Double subtotal = jsonObject.getJSONObject("1385974ed5904a438616ff7bdb3f7439").
                getJSONObject("line_tax_data").
                getJSONObject("subtotal").
                getDouble("1");
        System.out.println(subtotal);
    }

    @Test
    public void getCartContentMap() {
        String endpoint = "/cocart/v1/get-cart";
        Response response = serviceHelper.sendGetRequest(endpoint);

        Map<String, Object> products = response.getBody().jsonPath().get();

        for (Map.Entry<String, Object> product : products.entrySet()) {

            Map<String, Object> values = (Map<String, Object>) product.getValue();
            System.out.println(values.get("product_name"));
        }
    }
}
