package json;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

public class SimpleExample {
    static String json;

    @Test
    public  void setup() {
        try {
            URL fileUrl = TestJsonPathExpressions.class.getClassLoader().getResource("widget.json");
            File file = new File(fileUrl.getFile());
            json = new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}