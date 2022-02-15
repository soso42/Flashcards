package flashcards;

import static flashcards.Logger.printAndLog;

public class ResetStatsCommand implements CommandInterface {

    private CardService cardService;

    public ResetStatsCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        cardService.resetMistakeCount();
        printAndLog("Card statistics have been reset.\n");
    }
}
