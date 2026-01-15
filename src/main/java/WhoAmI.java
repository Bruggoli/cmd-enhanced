import java.io.File;
import java.io.IOException;

// Empty enum here because there are no flags for this command
enum WhoAmIFlags {};

/**
 * WhoAmI
 */
public record WhoAmI(String args) implements Function {
    public void execute() {
        String cmd = "whoami";
        if (!args.isEmpty()) {
            System.out.println("goofball");
        }
        buildProcess(cmd);
    }

    private static void buildProcess(String cmd) {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();
        pb.directory(new File("."));
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

