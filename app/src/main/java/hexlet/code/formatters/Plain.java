package hexlet.code.formatters;

import hexlet.code.Data;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(Map<String, Data> map) throws Exception {
        StringBuffer sb = new StringBuffer("");
        for (Map.Entry<String, Data> me : map.entrySet()) {
            Data data = me.getValue();
            Object val1 = data.getVal1();
            Object val2 = data.getVal2();
            String representationVal1 = getRepresentation(val1);
            String representationVal2 = getRepresentation(val2);
            switch (data.getStatus()) {
                case "added" -> {
                    sb.append("Property " + "'" + me.getKey() + "'" + " was added with value: "
                            + representationVal2 + "\n");
                }
                case "deleted" -> {
                    sb.append("Property " + "'" + me.getKey() + "'" + " was removed" + "\n");
                }
                case "changed" -> {
                    sb.append("Property " + "'" + me.getKey() + "'" + " was updated. From "
                            + representationVal1 + " to " + representationVal2 + "\n");
                }
                case "unchanged" -> {
                    continue;
                }
                default -> {
                    throw new Exception("Stylish.java: Status " + data.getStatus() + " is wrong!");
                }
            }
        }
        String result = sb.toString();
        return result;
    }

    private static String getRepresentation(Object val) {
        if (val instanceof String) {
            return "'" + String.valueOf(val) + "'";
        } else if (val instanceof List<?> | val instanceof Array | val instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return String.valueOf(val);
        }
    }
}
