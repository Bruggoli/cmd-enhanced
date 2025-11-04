package cmd;

// Testing running bash scripts through java
// I love method overloading
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class RunningBasicBash {
  private static final Logger log = Logger.getLogger(RunningBasicBash.class.getName());
  public static void main(String[] args) throws IOException {
    if (args.length > 0) {

      switch (args[0].toLowerCase()) {
        case "ls": { 
          try {
            fun = new LS(args[1]); 
          } catch (ArrayIndexOutOfBoundsException e) {
            fun = new LS("");
          }
        } break;
        case "pwd": {
          try {
          fun = new PWD(args[1]); 
          } catch (ArrayIndexOutOfBoundsException e) {
            fun = new PWD("");
          }
        } 
        break;
        case "whoami":  { fun = new WhoAmI(args[1]); } break;
        
        default: log.warning("Cant find command: " + args[0] + " is not valid.");
      }
    } else {
      System.out.println("No arguments given");
    }
    fun.execute();
  }
  // lsHelper(args[1]);

  private static Function fun = new LS(""); 
}
