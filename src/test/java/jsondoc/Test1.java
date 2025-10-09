package jsondoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    String jsonObject = "{\n" +
            "    \"store\": {\n" +
            "        \"book\": [\n" +
            "            {\n" +
            "                \"category\": \"reference\",\n" +
            "                \"author\": \"Nigel Rees\",\n" +
            "                \"title\": \"Sayings of the Century\",\n" +
            "                \"price\": 8.95\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"Evelyn Waugh\",\n" +
            "                \"title\": \"Sword of Honour\",\n" +
            "                \"price\": 12.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"Herman Melville\",\n" +
            "                \"title\": \"Moby Dick\",\n" +
            "                \"isbn\": \"0-553-21311-3\",\n" +
            "                \"price\": 8.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"J. R. R. Tolkien\",\n" +
            "                \"title\": \"The Lord of the Rings\",\n" +
            "                \"isbn\": \"0-395-19395-8\",\n" +
            "                \"price\": 22.99\n" +
            "            }\n" +
            "        ],\n" +
            "        \"bicycle\": {\n" +
            "            \"color\": \"red\",\n" +
            "            \"price\": 19.95\n" +
            "        }\n" +
            "    },\n" +
            "    \"expensive\": 10,\n" +
            "   \"skills\": [\"Java\", \"Selenium\", \"API\"]\n" +
            "}";

    @Test
    public void changeValueOfUsingJsonPath() throws JsonProcessingException {
        //jsonObject  jsonPath= JsonPath(jsonObject);
        String newJson = "{\"author\":\"Dydkoxxxxx\",\"price\":3000.1,\"category\":\"tech\",\"title\":\"Ucz się\"}";

        Map<String, Object> newBook1 = new HashMap<>();
        newBook1.put("category", "tech");
        newBook1.put("author", "Dydkoyyyyy");
        newBook1.put("title", "Ucz się");
        newBook1.put("price", 3000.1);

        String jsonObject1 = JsonPath.parse(jsonObject)
                .set("$.expensive", 1000)
                .set("store.book[*].title", "Miro tu był old")
                .set("skills[1]", "Python1")
                .set("store.book[0]", newBook1)
                .set("store.book[1]", newJson)
                .set("store.book[2]", new ObjectMapper().readValue(newJson, Map.class))
                .jsonString();
        System.out.println(jsonObject1);
    }

    @Test
    public void changeValueFilterNestedUsingJsonPAth() throws JsonProcessingException {
        //jsonObject  jsonPath= JsonPath(jsonObject);
        String newJson = "{\"author\":\"Dydkoxxxxx\",\"price\":3000.1,\"category\":\"tech\",\"title\":\"Ucz się\"}";

        Map<String, Object> newBook1 = new HashMap<>();
        newBook1.put("category", "tech");
        newBook1.put("author", "Dydkoyyyyy");
        newBook1.put("title", "Ucz się");
        newBook1.put("price", 3000.1);

        String jsonObject1 = JsonPath.parse(jsonObject)
                .set("store.book[?(@.title == 'Sword of Honour')]", "Miro tu byl12")
                .jsonString();
        System.out.println(jsonObject1);
    }
}