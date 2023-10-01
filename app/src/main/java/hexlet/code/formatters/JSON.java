package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Data;

import java.util.Map;

public class JSON {
    public static String format(Map<String, Data> map) throws Exception {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(map);
        return result;
    }
}
