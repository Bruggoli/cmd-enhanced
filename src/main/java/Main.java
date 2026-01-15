// Testing running bash scripts through java
// I love method overloading

import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    static void main(String[] args) {

        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "ls": {
                    try {
                        fun = new LS(args[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        log.warning("No arguments, running base command");
                        fun = new LS("");
                    }
                }
                break;
                case "pwd": {
                    try {
                        fun = new PWD(args[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        log.warning("No arguments, running base command");
                        fun = new PWD("");
                    }
                }
                break;
                case "whoami": {
                    try {
                        fun = new WhoAmI(args[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        log.warning("No arguments, dude knows how whoami works");
                    }
                    fun = new WhoAmI("");
                }
                break;
                case "curl": {
                    try {
                        fun = new CURL(args[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        log.warning("What are you doing?");
                    }
                    fun = new CURL("https://www.youtube.com/watch?v=bZe5J8SVCY");
                }
                break;default:
                    log.warning("Cant find command: " + args[0] + " is not valid.");
            }
        } else {
            System.out.println("No arguments given");
        }

        fun.execute();

    }
    private static Function fun = new LS("");
}
