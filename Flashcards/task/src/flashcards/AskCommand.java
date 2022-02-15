package flashcards;

import java.util.ArrayList;
import java.util.Random;

import static flashcards.Main.scanner;
import static flashcards.Logger.printAndLog;
import static flashcards.Logger.log;

public class AskCommand implements CommandInterface {

    private CardService cardService;

    public AskCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        printAndLog("How many times to ask?");
        String input = scanner.nextLine();
        int repeats = Integer.parseInt(input);

        log("> " + input);

        ArrayList<String> keyList = cardService.getKeyList();
        Random random = new Random();

        for (int i = 0; i < repeats; i++) {

            String card = keyList.get(random.nextInt(keyList.size()));
            String definition = cardService.getCardDefinition(card);

            printAndLog("Print the definition of \"" + card + "\":");
            input = scanner.nextLine();
            log("> " + input);

            if (input.equals(definition)) {
                printAndLog("Correct!");
            } else {

                if (cardService.containsDefinition(input)) {
                    printAndLog(String.format("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".",
                            definition, cardService.getCardByDefinition(input)));
                } else {
                    printAndLog(String.format("Wrong. The right answer is \"%s\".", definition));
                }

                // Update mistake count
                cardService.updateMistakeCount(card);
            }

            printAndLog("");
        }
    }
}
