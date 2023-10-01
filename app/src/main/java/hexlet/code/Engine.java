package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.util.Map;
import java.util.TreeMap;

public class Engine {
    public static String check(String filePath1, String filePath2) throws Exception {
        return check(filePath1, filePath2, "stylish");
    }

    public static String check(String filePath1, String filePath2, String format) throws Exception {
        Path firstFilePath = createPath(filePath1);
        Path secondFilePath = createPath(filePath2);

        String file1Extension = getExtension(String.valueOf(firstFilePath));
        String file2Extension = getExtension(String.valueOf(secondFilePath));

        String contentFile1 = Files.readString(firstFilePath);
        String contentFile2 = Files.readString(secondFilePath);

        TreeMap<String, Object> file1 = new TreeMap<>(Parser.parse(contentFile1, file1Extension));
        TreeMap<String, Object> file2 = new TreeMap<>(Parser.parse(contentFile2, file2Extension));
        Map<String, Data> res = Differ.generate(file1, file2);
        String result = Formatter.create(res, format);
        return result;
    }

    private static Path createPath(String pathString) throws Exception {
        try {
            return Paths.get(pathString);
        } catch (InvalidPathException e) {
            System.out.println("wrong!!!!!");
            String pathMessage = e.getMessage();
            if (pathMessage == null) {
                pathMessage = e.toString();
                System.out.println("Это pathMessage - " + pathMessage);
            }
            throw new Exception("Path " + pathString + " is wrong!");
        }
    }

    private static String getExtension(String path) {
        int dotIndex = path.lastIndexOf('.');
        return dotIndex > 0
                ? path.substring(dotIndex + 1) : "";
    }
}
