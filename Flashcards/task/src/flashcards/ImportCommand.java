package flashcards;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static flashcards.Logger.printAndLog;
import static flashcards.Main.scanner;
import static flashcards.Logger.log;

public class ImportCommand implements CommandInterface {

    private CardService cardService;

    public ImportCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        printAndLog("File name: ");
        String fileName = scanner.nextLine();

        // Log User input
        log("> " + fileName);

        cardService.addCardsFromList(importFromFile(fileName));

        printAndLog("");
    }

    public static List<String> importFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Path.of(fileName));

            list = stream
                    .collect(Collectors.toList());

            stream = Files.lines(Path.of(fileName));

            printAndLog(String.format("%d cards have been loaded.", stream.count()));
        } catch (IOException e) {
            printAndLog("File not found.");
        }
        return list;
    }
}
