package programautomatycy.StartTest.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemToCardRequestPojo {

    @JsonProperty
    private Integer product_id;
    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private Boolean return_cart;

    public AddItemToCardRequestPojo(Integer product_id, Integer quantity, Boolean return_cart) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.return_cart = return_cart;
    }

}
