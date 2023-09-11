package hexlet.code;

import java.io.IOException;
import java.nio.file.*;
import java.lang.Throwable;
import java.util.HashMap;
import java.util.Map;

public class Checker {
    public static String check (String filePath1, String filePath2) throws Exception {
        return check(filePath1, filePath2, "stylish");
    }

    public static String check (String filePath1, String filePath2, String format) throws Exception {
        Path firstFilePath = createPath(filePath1);
        Path secondFilePath = createPath(filePath2);
        String contentFile1 = Files.readString(firstFilePath);
        String contentFile2 = Files.readString(secondFilePath);

        Map<String, Object> file1 = new HashMap<>(Parser.parse(contentFile1));
        Map<String, Object> file2 = new HashMap<>(Parser.parse(contentFile2));
        System.out.println(file1);
        System.out.println(file2);

//        {
//            - follow: false
//              host: hexlet.io
//            - proxy: 123.234.53.22
//            - timeout: 50
//            + timeout: 20
//            + verbose: true
//        }

        return contentFile1;
    }

    private static Path createPath(String pathString) throws Exception {
        try {
            return Paths.get(pathString);
        } catch (InvalidPathException e) {
            System.out.println("wrong!!!!!");
            String pathMessage = e.getMessage();
            if(pathMessage == null) {
                pathMessage = e.toString();
                System.out.println("Это pathMessage - " + pathMessage);
            }
            throw new Exception("Path " + pathString + " is wrong!");
        }
    }

}
