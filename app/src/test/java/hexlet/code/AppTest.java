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
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJSON;
    @BeforeAll
    public static void beforeAll() throws IOException {
        expectedStylish = Files.readString(Path.of("src/test/resources/result2.txt"));
        expectedPlain = Files.readString(Path.of("src/test/resources/result3.txt"));
        expectedJSON = Files.readString(Path.of("src/test/resources/result4.txt"));
    }

    @Test
    void testGenerateToDefaultFromJSON() throws Exception {
        String res = Differ.generate("src/test/resources/file3.json", "src/test/resources/file4.json");
        assertEquals(expectedStylish, res);
    }

    @Test
    void stylishTestJSON() throws Exception {
        String res = Differ.generate("src/test/resources/file3.json", "src/test/resources/file4.json", "stylish");
        assertEquals(expectedStylish, res);
    }

    @Test
    void testYAML() throws Exception {
        String res = Differ.generate("src/test/resources/file3.yml", "src/test/resources/file4.yml");
        assertEquals(expectedStylish, res);
    }

    @Test
    void stylishTestYAML() throws Exception {
        String res = Differ.generate("src/test/resources/file3.yml", "src/test/resources/file4.yml", "stylish");
        assertEquals(expectedStylish, res);
    }
    @Test
    void testPlain() throws Exception {
        String res = Differ.generate("src/test/resources/file3.yml", "src/test/resources/file4.yml", "plain");
        assertEquals(expectedPlain, res);
    }
    @Test
    void testjson() throws Exception {
        String res = Differ.generate("src/test/resources/file3.yml", "src/test/resources/file4.yml", "json");
        assertEquals(expectedJSON, res);
    }
}
