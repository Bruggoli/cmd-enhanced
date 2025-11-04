package cmd;

import java.io.File;
import java.io.IOException;

/**
 * PWD
 */
public record PWD(String args) implements Function {
  public void execute() {
    String cmd = "pwd";
    ProcessBuilder pb = new ProcessBuilder(cmd);
    if (!args.isEmpty()) {
      //TODO: check if it has - before args
      cmd += " " + args;
    }
    pb.inheritIO();
    pb.directory(new File(System.getProperty("user.dir")));
    try {
      pb.start();
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }
}


