package hexlet.code;

import java.util.*;

public class Differ {
    public static Map<String, Data> generate(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Data> result = new TreeMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key: keys) {
            if (!map1.containsKey(key)) {
                result.put(key, new Data("added", null, map2.get(key)));
            } else if (map1.containsKey(key)) {
                Object val1 = map1.get(key);
                if (!map2.containsKey(key)) {
                    result.put(key, new Data("deleted", map1.get(key), null));
                } else {
                    Object val2 = map2.get(key);
                    if (Objects.equals(val1, val2)) {
                        result.put(key, new Data("unchanged", map1.get(key), map2.get(key)));
                    } else {
                        result.put(key, new Data("changed", map1.get(key), map2.get(key)));
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
//    public static <V> String generate(Map<String, V> map1, Map<String, V> map2) {
//        String result = "";
//        StringBuilder sb = new StringBuilder("{\n");
//
//        for (Map.Entry<String, V> data : map1.entrySet()) {
//            String key = data.getKey();
//            Object value = data.getValue();
//            if (map2.containsKey(key)) {
//                if (map2.containsValue(value)) {
//                    sb.append("   ").append(key).append(": ").append(value).append("\n");
//                } else {
//                    sb.append(" - ").append(key).append(": ").append(value).append("\n");
//                }
//            } else {
//                sb.append(" - ").append(key).append(": ").append(value).append("\n");
//            }
//        }
//        for (Map.Entry<String, V> data : map2.entrySet()) {
//            String key = data.getKey();
//            Object value = data.getValue();
//            if (map1.containsKey(key)) {
//                if (Objects.equals(value, map1.get(key))) {
//                    sb.append(" + ").append(key).append(": ").append(value).append("\n");
//                }
//            } else {
//                sb.append(" + ").append(key).append(": ").append(value).append("\n");
//            }
//        }
//        result = sb.append("}").toString();
//        return result;
//    }
}
