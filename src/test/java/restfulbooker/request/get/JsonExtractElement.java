package restfulbooker.request.get;

import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.stream.Collectors;

public class JsonExtractElement {
    public static void main(String[] args) {
        String j = "[\n" +
                "10,20,30,4,0,50\n" +
                "]";
        JsonPath jsonPath = new JsonPath(j);
        System.out.println(jsonPath.getString("[0]"));
        System.out.println(jsonPath.getList("$").size());
        List<String> l1 = jsonPath.getList("$");
        System.out.println(l1.stream().collect(Collectors.toList()));
        //System.out.println(l1.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }
}