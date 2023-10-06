/*
 * Created by zampolit 2023.09.18 at 10.47
 * version info - v0.1
 * Classname - EngineTest.java
 * This class performs unit testing of the generate() method
 */
package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;

public final class AppTest {
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;
    private static String pathToFixtures;

    @BeforeAll
    public static void beforeAll() throws Exception {
        pathToFixtures = "src/test/resources/";
        expectedStylish = getPathToFixtures("result2.txt");
        expectedPlain = getPathToFixtures("result3.txt");
        expectedJson = getPathToFixtures("result4.txt");
    }

    private static String getPathToFixtures(String fileName) throws Exception {
        return Files.readString(Path.of(pathToFixtures + fileName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void testGenerate(String format) throws Exception {
        String filePath1 = pathToFixtures + "file3." + format;
        String filePath2 = pathToFixtures + "file4." + format;

        assertEquals(expectedStylish, Differ.generate(filePath1, filePath2));
        assertEquals(expectedStylish, Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(expectedPlain, Differ.generate(filePath1, filePath2, "plain"));
        assertEquals(expectedJson, Differ.generate(filePath1, filePath2, "json"));
    }
}
