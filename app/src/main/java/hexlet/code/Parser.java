package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> parse(String str, String extension) throws Exception {
        Map<String, Object> result;
        ObjectMapper mapper;
        switch (extension) {
            case "json" -> {
                mapper = new ObjectMapper();
            }
            case "yml", "yaml" -> {
                mapper = new YAMLMapper();
            }
            default -> throw new RuntimeException("Unsupported format: " + extension);
        }
        result = mapper.readValue(str, Map.class);
        return result;
    }
}
