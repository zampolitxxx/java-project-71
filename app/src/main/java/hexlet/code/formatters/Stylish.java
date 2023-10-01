package hexlet.code.formatters;

import hexlet.code.Data;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, Data> map) throws Exception {
        StringBuffer sb = new StringBuffer("{\n");
        for (Map.Entry<String, Data> me : map.entrySet()) {
            Data data = me.getValue();
            switch (data.getStatus()) {
                case "added" -> {
                    sb.append("  + " + me.getKey() + ": " + data.getVal2() + "\n");
                }
                case "deleted" -> {
                    sb.append("  - " + me.getKey() + ": " + data.getVal1() + "\n");
                }
                case "unchanged" -> {
                    sb.append("    " + me.getKey() + ": " + data.getVal1() + "\n");
                }
                case "changed" -> {
                    sb.append("  - " + me.getKey() + ": " + data.getVal1() + "\n");
                    sb.append("  + " + me.getKey() + ": " + data.getVal2() + "\n");
                }
                default -> {
                    throw new Exception("Stylish.java: Status " + data.getStatus() + " is wrong!");
                }
            }

        }
        sb.append("}");
        String result = sb.toString();
        return result;
    }
}
