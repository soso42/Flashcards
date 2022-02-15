package flashcards;

import static flashcards.Main.scanner;
import static flashcards.Logger.printAndLog;
import static flashcards.Logger.log;

public class RemoveCommand implements CommandInterface {

    private CardService cardService;

    public RemoveCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        printAndLog("Which card? ");

        String card = scanner.nextLine();

        log("> " + card);

        if (cardService.containsCard(card)) {
            cardService.removeCard(card);
            printAndLog("The card has been removed.");
        } else {
            printAndLog(String.format("Can't remove \"%s\": there is no such card.\n", card));
        }
    }
}
