package programautomatycy.StartTest;

import net.minidev.json.JSONObject;
import org.junit.Test;

import static utils.JsonRequestBodyHelper.getJsonFromFile;


public class E_PostMethodBody {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    private final String endpoint = "/cocart/v1/add-item";

    @Test
    public void addItemBodyFromFile() {
        JSONObject object = getJsonFromFile("request-shop-add-item-to-cart", "add_item_body");

        serviceHelper.sendPostRequest(object.toString(), endpoint);


    }
}
