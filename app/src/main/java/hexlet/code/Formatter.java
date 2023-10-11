package hexlet.code;

import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.JSON;
import java.util.Map;

public class Formatter {
    public static String create(Map<String, Data> data, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(data);
            case "plain" -> Plain.format(data);
            case "json" -> JSON.format(data);
            default -> throw new RuntimeException("Formatter.java: format "  + "'" + format + "'" + " is wrong!");
        };
    }


}
