/*
* created by zampolit 04.09.2023
* the class interacts with piccoli and passes it to the Engine.java
* in the form of arguments:
* path to the first file;
* path to the second file;
* data output format
 */

package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true,
        version = "gendiff 0.1", description = "Compares two configuration files and shows a difference.")

public final class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"},
        description = "output format [default: stylish]",
        paramLabel = "format",
        defaultValue = "stylish")
    private String format;

    @Parameters(index = "0", description = "Path to first file")
    private String filePathFirst;

    @Parameters(index = "1", description = "Path to second file")
    private String filePathSecond;

    @Override
    public Integer call() throws Exception {
        try {
            String result = Differ.generate(filePathFirst, filePathSecond, format);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Something wrong");
            e.printStackTrace();
            System.err.println(e.getStackTrace().getClass());
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
