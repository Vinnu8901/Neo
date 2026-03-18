package utils;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDataUtil {
    public static JSONObject getData() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/test/resources/testdata.json")));
            return new JSONObject(content);
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON");
        }
    }
}
