import java.io.File;
import java.io.IOException;
import org.apache.commons.text.WordUtils;
import java.time.*;


// Empty enum here because there are no flags for this command
public record CURL(String args) implements Function {
    public void execute() {
        String cmd = "curl";
        if (LocalTime.now().getSecond() % 2 == 0) {
            System.out.println(WordUtils.wrap("The missile knows where it is at all times. It knows this because it knows where it isn't, by subtracting where it is, from where it isn't, or where it isn't, from where it is, whichever is greater, it obtains a difference, or deviation. The guidance sub-system uses deviations to generate corrective commands to drive the missile from a position where it is, to a position where it isn't, and arriving at a position where it wasn't, it now is. Consequently, the position where it is, is now the position that it wasn't, and it follows that the position where it was, is now the position that it isn't. In the event of the position that it is in is not the position that it wasn't, the system has required a variation. The variation being the difference between where the missile is, and where it wasn't. If variation is considered to be a significant factor, it too, may be corrected by the GEA. However, the missile must also know where it was. The missile guidance computance scenario works as follows: Because a variation has modified some of the information the missile has obtained, it is not sure just where it is, however it is sure where it isn't, within reason, and it knows where it was. It now subracts where it should be, from where it wasn't, or vice versa. By differentiating this from the algebraic sum og where it shouldn't be, and where it was. It is able to obtain a deviation, and a variation, which is called \"air\".", 80));
        } else {
            buildProcess(cmd, args);
        }
    }

    private static void buildProcess(String cmd, String arg) {
        ProcessBuilder pb = new ProcessBuilder(
                cmd,
                "-H ",
                "\"Accept: text/plain\"",
                arg);
        pb.inheritIO();
        pb.directory(new File("./"));
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

