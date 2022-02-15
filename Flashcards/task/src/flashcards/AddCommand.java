package flashcards;

import static flashcards.Main.scanner;
import static flashcards.Logger.printAndLog;
import static flashcards.Logger.log;

class AddCommand implements CommandInterface {

    private CardService cardService;

    public AddCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        String card;
        String definition;

        printAndLog("The card: ");
        card = scanner.nextLine();
        log("> " + card);

        if (cardService.containsCard(card)) {
            printAndLog(String.format("The card \"%s\" already exists.\n", card));
            return;
        }

        printAndLog("The definition of the card: ");

        definition = scanner.nextLine();
        log("> " + definition);

        if (cardService.containsDefinition(definition)) {
            printAndLog(String.format("The definition \"%s\" already exists.\n", definition));
            return;
        }

        cardService.addCard(card, definition);
        printAndLog(String.format("The pair (\"%s\":\"%s\") has been added.", card, definition));
        printAndLog("");
    }

}
