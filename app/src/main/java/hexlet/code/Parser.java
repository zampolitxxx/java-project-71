package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> parse(String str, String extension) throws Exception {
        return switch (extension) {
            case "json" -> new ObjectMapper().readValue(str, Map.class);
            case "yml", "yaml" -> new YAMLMapper().readValue(str, Map.class);
            default -> throw new RuntimeException("Unsupported format: " + extension);
        };
    }
}
