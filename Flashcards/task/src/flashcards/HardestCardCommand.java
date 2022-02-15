package flashcards;

import java.util.*;

import static flashcards.Logger.log;
import static flashcards.Logger.printAndLog;

public class HardestCardCommand implements CommandInterface {

    private CardService cardService;

    public HardestCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        HashMap<String, Integer> hardestCards = cardService.getHardestCards();

        if (hardestCards.size() == 0) {
            printAndLog("There are no cards with errors.");
        } else if (hardestCards.size() == 1) {
            Set<String> list = hardestCards.keySet();
            String key = list.iterator().next();
            printAndLog(String.format("The hardest card is \"%s\". You have %d errors answering it.",
                    key, hardestCards.get(key)));
        } else {
            StringBuilder sb = new StringBuilder();
            long totalMistakes = hardestCards.values().stream()
                    .reduce(0, (sum, next) -> sum += next);

            sb.append("The hardest cards are \"");

            LinkedList<String> keyList = new LinkedList<>(hardestCards.keySet());

            sb.append(keyList.get(0));

            for (int i = 1; i < keyList.size(); i++) {
                sb.append("\", \"").append(keyList.get(i));
            }

            sb.append("\". You have ").append(totalMistakes).append(" errors answering them.");

            printAndLog(sb.toString());
        }

        printAndLog("");
    }
}
