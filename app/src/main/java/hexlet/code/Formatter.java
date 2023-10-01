package hexlet.code;

import java.util.Map;

public class Formatter {
    public static String create(Map<String, Data> data, String format) throws Exception {
        String result;
        switch (format) {
            case "stylish" -> {
                result = Stylish.format(data);
            }
            default -> {
                result = "Unknown format " + "'" + format + "'";
            }
        }
        return result;
    }


}
