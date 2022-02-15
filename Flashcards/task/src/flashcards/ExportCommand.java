package flashcards;

import java.io.FileOutputStream;
import java.io.IOException;

import static flashcards.Main.scanner;
import static flashcards.Logger.printAndLog;
import static flashcards.Logger.log;

public class ExportCommand implements CommandInterface {

    private CardService cardService;

    public ExportCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        printAndLog("File name: ");
        String fileName = scanner.nextLine();
        log("> " + fileName);

        exportToFile(fileName, cardService.allCardsToString(), cardService.getNumberOfFlashcards());

        printAndLog("");
    }

    public static void exportToFile(String fileName, String text, int numOfCards) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, false);
            fos.write(text.getBytes());
            fos.close();

            printAndLog(String.format("%d cards have been saved.", numOfCards));
        } catch (IOException e) {
            printAndLog("File can't be open or there was some other IO error");
        }
    }
}
