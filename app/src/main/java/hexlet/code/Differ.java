/*
 * Created by zampolit 20.09.2023
 * Accepts from App.java file paths, data output format.
 * Calls all auxiliary methods and returns the result to the App.java as a string.
 */
package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Path firstFilePath = createPath(filePath1);
        Path secondFilePath = createPath(filePath2);

        String file1Extension = getExtension(filePath1);
        String file2Extension = getExtension(filePath2);

        String contentFile1 = Files.readString(firstFilePath);
        String contentFile2 = Files.readString(secondFilePath);

        Map<String, Object> file1 = Parser.parse(contentFile1, file1Extension);
        Map<String, Object> file2 = Parser.parse(contentFile2, file2Extension);
        Map<String, Data> res = DifferenceFinder.generate(file1, file2);
        String result = Formatter.create(res, format);
        return result;
    }

    private static Path createPath(String pathString) {
        try {
            return Paths.get(pathString);
        } catch (InvalidPathException e) {
            String pathMessage = e.getMessage();
            if (pathMessage == null) {
                pathMessage = e.toString();
                System.out.println("Это pathMessage - " + pathMessage);
            }
            throw new RuntimeException("Path " + pathString + " is wrong!");
        }
    }

    private static String getExtension(String path) {
        int dotIndex = path.lastIndexOf('.');
        return dotIndex > 0
                ? path.substring(dotIndex + 1) : "";
    }
}
