package flashcards;

import java.io.FileOutputStream;
import java.io.IOException;

import static flashcards.Logger.*;
import static flashcards.Main.scanner;

public class LogCommand implements CommandInterface {

    @Override
    public void execute() {
        printAndLog("File name: ");
        String fileName = scanner.nextLine();
        log("> " + fileName);

        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);
            fos.write(getLogsToString().getBytes());
            fos.close();

            printAndLog("The log has been saved.");
        } catch (IOException e) {
            printAndLog("File can't be open or there was some other IO error");
        }
        printAndLog("");
    }
}
