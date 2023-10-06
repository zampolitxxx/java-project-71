package hexlet.code;

import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.JSON;
import java.util.Map;

public class Formatter {
    public static String create(Map<String, Data> data, String format) throws Exception {
        String result;
        switch (format) {
            case "stylish" -> {
                result = Stylish.format(data);
            }
            case "plain" -> {
                result = Plain.format(data);
            }
            case "json" -> {
                result = JSON.format(data);
            }
            default -> {
                throw new RuntimeException("Formatter.java: format "  + "'" + format + "'" + " is wrong!");
            }
        }
        return result;
    }


}
