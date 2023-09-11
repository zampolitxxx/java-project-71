package hexlet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> parse(String str) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper om = new ObjectMapper();
        result = om.readValue(str, Map.class);
        return result;
    }
}
