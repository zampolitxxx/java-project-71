package hexlet.code;

import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
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
            default -> {
                throw new Exception("Formatter.java: format "  + "'" + format + "'" + " is wrong!");
            }
        }
        return result;
    }


}
