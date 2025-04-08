package programautomatycy.StartTest;

import org.junit.Test;

import java.util.Map;

public class B_PostMethodFormData {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItem() {
        Integer product_id = 142;
        Integer quantity = 112;
        Boolean returnCart = true;
        final String endpoint = "/cocart/v1/add-item";

        serviceHelper.addItem(product_id, quantity, returnCart, endpoint);
    }

    @Test
    public void addItemWithFormData() {
        Map<String, Object> queryParamsBody = Map.of(
                "product_id", 142,
                "quantity", 100,
                "returnCart", true);
        final String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void calculate(){
        Map<String,Object> queryParamsBody = Map.of("return", true);
        final String endpoint = "/cocart/v1/calculate";
        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }
}
