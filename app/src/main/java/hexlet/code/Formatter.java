package hexlet.code;

public class Formatter {
    public static String add(String key, Object value, String prefix) {
        String result = "";
        StringBuilder sb = new StringBuilder("{\n");
        sb.append("   ").append(key).append(": ").append(value).append("\n");
        return result;
    }


}
