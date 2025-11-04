package cmd;

import java.io.File;
import java.io.IOException;

/**
 * PWD
 */
public record LS(String path) implements Function {
  public void execute() {

    String cmd = "ls";
    if (!path.isEmpty() && !validatePath(path))
      throw new RuntimeException("Path must be absolute: \n\"" + path + "\" is not valid.");
    
    ProcessBuilder pb = new ProcessBuilder(cmd);
    pb.inheritIO();
    pb.directory(new File(!path.isEmpty() ? path : System.getProperty("user.dir")));
    try {
      pb.start();
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }

  // For now requires absolute path
  private static boolean validatePath(String str) {
    if (!str.startsWith("/"))
      return false;
    return true;
  } 
}


