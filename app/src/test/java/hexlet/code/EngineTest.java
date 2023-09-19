/*
 * Created by zampolit 2023.09.18 at 10.47
 * version info - v0.1
 * Classname - EngineTest.java
 * This class performs unit testing of the generate() method
 */

package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EngineTest {
    static String resources = "src/test/resources/result.txt";
    @Test
    void test() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        Path realPath = Paths.get(resources);
        String result = Engine.check(filePath1, filePath2);
        String real = Files.readString(realPath);
        assertEquals(real, result);
    }
}
