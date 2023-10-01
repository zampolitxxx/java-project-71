package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> parse(String str, String extension) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper om = null;
        if (extension.equals("json")) {
            om = new ObjectMapper();
        } else if (extension.equals("yml")) {
            om = new YAMLMapper();
        }
        result = om.readValue(str, Map.class);
        return result;
    }
}
