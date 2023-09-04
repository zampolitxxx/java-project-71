package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        version = "gendiff 0.1", description = "Compares two configuration files and shows a difference.")

public class App implements Callable{

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("hello");
        } catch(Exception e) {
            System.err.println(e.getMessage());
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
