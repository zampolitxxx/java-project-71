package hexlet.code;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, Data> map) {
        StringBuffer sb = new StringBuffer("{\n");
        for (Map.Entry<String, Data> me : map.entrySet()) {
            Data data = me.getValue();
            switch (data.getStatus()) {
                case "added" -> {
                    sb.append(" + " + me.getKey() + ": " + data.getVal2() + "\n");
                }
                case "deleted" -> {
                    sb.append(" - " + me.getKey() + ": " + data.getVal1() + "\n");
                }
                case "unchanged" -> {
                    sb.append("   " + me.getKey() + ": " + data.getVal1() + "\n");
                }
                case "changed" -> {
                    sb.append(" - " + me.getKey() + ": " + data.getVal1() + "\n");
                    sb.append(" + " + me.getKey() + ": " + data.getVal2() + "\n");
                }
                default -> {
                    sb.append("Wrong argument!");
                }
            }

        }
        String result = sb.toString();
        return result;
    }
}
