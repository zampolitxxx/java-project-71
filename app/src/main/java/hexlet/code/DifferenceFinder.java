/*
 * Created by zampolit 20.09.2023
 * Returns the map in the format: String key: Data value.
 * Data is my Class. It has fields: String status, Object val1, Object val2
 */
package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class DifferenceFinder {
    public static Map<String, Data> generate(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Data> result = new TreeMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key: keys) {
            if (!map1.containsKey(key)) {
                result.put(key, new Data("added", null, map2.get(key)));
            } else if (!map2.containsKey(key)) {
                result.put(key, new Data("deleted", map1.get(key), null));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                result.put(key, new Data("unchanged", map1.get(key), map2.get(key)));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                result.put(key, new Data("changed", map1.get(key), map2.get(key)));
            }
        }
        return result;
    }
}

