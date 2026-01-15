import java.io.File;
import java.io.IOException;

enum LSFlags {
    L, A
}

/**
 * LS
 */
public record LS(String path) implements Function {
    public void execute() {

        String cmd = "ls";
        if (!path.isEmpty() && !validatePath(path))
            throw new RuntimeException("Path must be absolute: \n\"" + path + "\" is not valid.");

        buildProcess(cmd);
    }

    private void buildProcess(String cmd) {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();
        pb.directory(new File(!path.isEmpty() ? path : System.getProperty("user.dir")));
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println("Failed to start LS: " + e.getMessage());
        }
    }

    // For now requires absolute path
    private static boolean validatePath(String str) {
        if (!str.startsWith("/"))
            return false;
        return true;
    }
}

