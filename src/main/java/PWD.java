import java.io.File;
import java.io.IOException;

enum PWDFlags {
    LOGICAL,
    PHYSICAL,
    HELP,
    VERSION
}

/**
 * PWD
 */
public record PWD(String args) implements Function {
    public void execute() {
        String cmd = "pwd";

        if (!args.isEmpty()) {
            //TODO: check if it has - before args

            cmd += " " + args;
        }
        buildProcess(cmd);
    }

    private static void buildProcess(String cmd) {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();
        pb.directory(new File(System.getProperty("user.dir")));
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}


