package flashcards;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import static flashcards.Logger.*;
import static flashcards.ImportCommand.importFromFile;
import static flashcards.ExportCommand.exportToFile;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static CardService cardService = new CardService();
    static HashMap<String, String> arguments = new HashMap<>();

    public static void main(String[] args) {

        CommandExecutor commandExecutor = new CommandExecutor();

        parseArgs(args);

        // If there was -import argument, imports data from file
        importDataFromFile();

        while (true) {
            printAndLog("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String input = scanner.nextLine();
            log("> " + input);
            switch (input) {
                case "add": {
                    commandExecutor.setCommand(new AddCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "remove": {
                    commandExecutor.setCommand(new RemoveCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "import": {
                    commandExecutor.setCommand(new ImportCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "export": {
                    commandExecutor.setCommand(new ExportCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "ask": {
                    commandExecutor.setCommand(new AskCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "log": {
                    commandExecutor.setCommand(new LogCommand());
                    commandExecutor.execute();
                    break;
                }
                case "hardest card": {
                    commandExecutor.setCommand(new HardestCardCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "reset stats": {
                    commandExecutor.setCommand(new ResetStatsCommand(cardService));
                    commandExecutor.execute();
                    break;
                }
                case "exit": {
                    printAndLog("Bye bye!");
                    // If there was -export argument, the logs will be saved to file
                    exportDataToFile();
                    return;
                }
                default: {
                    printAndLog("Unknown command, try again...\n");
                }
            }
        }

    }

    private static void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i+=2) {
            arguments.put(args[i], args[i + 1]);
        }
    }

    private static void importDataFromFile() {
        Optional<String> optFileName = Optional.ofNullable(arguments.get("-import"));
        optFileName.ifPresent(s -> cardService.addCardsFromList(importFromFile(s)));
    }

    private static void exportDataToFile() {
        Optional<String> optFileName = Optional.ofNullable(arguments.get("-export"));
        optFileName.ifPresent(s -> exportToFile(s, cardService.allCardsToString(), cardService.getNumberOfFlashcards()));
    }

}
