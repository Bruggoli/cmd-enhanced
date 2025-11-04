package cmd;

import java.io.File;
import java.io.IOException;

/**
 * PWD
 */
public record WhoAmI(String args) implements Function {
  public void execute() {
    String cmd = "whoami";
    if (!args.isEmpty()) {
      System.out.println("goofball");
    }
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


