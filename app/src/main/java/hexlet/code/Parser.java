package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> parse(String str, String extension) throws Exception {
        switch (extension) {
            case "json" -> {
                return new ObjectMapper().readValue(str, Map.class);
            }
            case "yml", "yaml" -> {
                return new YAMLMapper().readValue(str, Map.class);
            }
            default -> throw new RuntimeException("Unsupported format: " + extension);
        }
    }
}
