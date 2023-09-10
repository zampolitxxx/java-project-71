/*
* created by zampolit 04.09.2023
*/
package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true,
        version = "gendiff 0.1", description = "Compares two configuration files and shows a difference.")

public class App implements Callable{

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
            String result = Checker.check(filePathFirst, filePathSecond, format);
            System.out.println(result);
        } catch(Exception e) {
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
