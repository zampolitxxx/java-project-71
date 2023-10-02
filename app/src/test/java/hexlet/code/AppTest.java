/*
 * Created by zampolit 2023.09.18 at 10.47
 * version info - v0.1
 * Classname - EngineTest.java
 * This class performs unit testing of the generate() method
 */
package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppTest {
    private static String exp;
    private static String expPlain;
    private static String expJSON;
    @BeforeAll
    public static void beforeAll() throws IOException {
        exp = Files.readString(Path.of("src/test/resources/result2.txt"));
        expPlain = Files.readString(Path.of("src/test/resources/result3.txt"));
        expJSON = Files.readString(Path.of("src/test/resources/result4.txt"));
    }

    @Test
    void testJSON() throws Exception {
        String res = Engine.check("src/test/resources/file3.json", "src/test/resources/file4.json");
        assertEquals(exp, res);
    }

    @Test
    void stylishTestJSON() throws Exception {
        String res = Engine.check("src/test/resources/file3.json", "src/test/resources/file4.json", "stylish");
        assertEquals(exp, res);
    }

    @Test
    void testYAML() throws Exception {
        String res = Engine.check("src/test/resources/file3.yml", "src/test/resources/file4.yml");
        assertEquals(exp, res);
    }

    @Test
    void stylishTestYAML() throws Exception {
        String res = Engine.check("src/test/resources/file3.yml", "src/test/resources/file4.yml", "stylish");
        assertEquals(exp, res);
    }
    @Test
    void testPlain() throws Exception {
        String res = Engine.check("src/test/resources/file3.yml", "src/test/resources/file4.yml", "plain");
        assertEquals(expPlain, res);
    }
    @Test
    void testjson() throws Exception {
        String res = Engine.check("src/test/resources/file3.yml", "src/test/resources/file4.yml", "json");
        assertEquals(expJSON, res);
    }
}
