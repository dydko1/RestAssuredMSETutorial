package makeseleniumeasy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main1 {
    public static void main(String[] args) throws JsonProcessingException {
        // Create an object to ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating Node that maps to JSON Object structures in JSON content
        ObjectNode bookingDetails = objectMapper.createObjectNode();

        // It is similar to map put method. put method is overloaded to accept different types of data
        // String as field value
        bookingDetails.put("firstname", "Jim");
        bookingDetails.put("lastname", "Brown");
        // integer as field value
        bookingDetails.put("totalprice", 111);
        // boolean as field value
        bookingDetails.put("depositpaid", true);
        bookingDetails.put("additionalneeds", "Breakfast");
        // Duplicate field name. Will override value
        bookingDetails.put("additionalneeds", "Lunch");
        // To print created json object
        String createdPlainJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("Created plain JSON Object is : \n"+ createdPlainJsonObject);

        // Since requirement is to create a nested JSON Object
        ObjectNode bookingDateDetails = objectMapper.createObjectNode();
        bookingDateDetails.put("checkin", "2021-07-01");
        bookingDateDetails.put("checkout", "2021-07-01");

        // Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
        bookingDetails.set("bookingdates", bookingDateDetails);

        // To get the created json object as string. Use writerWithDefaultPrettyPrinter() for proper formatting
        String createdNestedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("Created nested JSON Object is : \n"+ createdNestedJsonObject);
    }
}
