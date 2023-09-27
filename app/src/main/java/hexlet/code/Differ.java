package hexlet.code;

import java.util.Map;
import java.util.Objects;

public class Differ {
    public static <V> String generate(Map<String, V> map1, Map<String, V> map2) {
        String result = "";
        StringBuilder sb = new StringBuilder("{\n");

        for (Map.Entry<String, V> data : map1.entrySet()) {
            String key = data.getKey();
            Object value = data.getValue();
            if (map2.containsKey(key)) {
                if (map2.containsValue(value)) {
                    sb.append("   ").append(key).append(": ").append(value).append("\n");
                } else {
                    sb.append(" - ").append(key).append(": ").append(value).append("\n");
                }
            } else {
                sb.append(" - ").append(key).append(": ").append(value).append("\n");
            }
        }
        for (Map.Entry<String, V> data : map2.entrySet()) {
            String key = data.getKey();
            Object value = data.getValue();
            if (map1.containsKey(key)) {
                if (Objects.equals(value, map1.get(key))) {
                    sb.append(" + ").append(key).append(": ").append(value).append("\n");
                }
            } else {
                sb.append(" + ").append(key).append(": ").append(value).append("\n");
            }
        }
        result = sb.append("}").toString();
        return result;
    }
}
