package programautomatycy.StartTest;

import org.junit.Test;

public class F_GetMethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getCartContent() {
        final String endpoint = "/cocart/v1/get-cart";
        serviceHelper
                .sendGetRequest(endpoint)
                .prettyPrint();
    }
}
