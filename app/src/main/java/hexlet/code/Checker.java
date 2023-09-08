package hexlet.code;

import java.io.IOException;
import java.nio.file.*;
import java.lang.Throwable;

public class Checker {
    public static String check (String filePath1, String filePath2) throws Exception {
        return check(filePath1, filePath2, "stylish");
    }

    public static String check (String filePath1, String filePath2, String format) throws Exception {
        Path firstFilePath = createPath(filePath1);
        String contentFile1 = Files.readString(firstFilePath);
        System.out.println(contentFile1);
        return contentFile1;
    }

    private static Path createPath(String pathString) throws Exception {
        try {
            return Paths.get(pathString);
        } catch (InvalidPathException e) {
            String pathMessage = e.getMessage();
            if(pathMessage == null) {
                pathMessage = e.toString();
                System.out.println("Это pathMessage - " + pathMessage);
            }
            throw new Exception("Path " + pathString + " is wrong!");
        }
    }

}
