package flashcards;

import java.util.*;

public class CardService {

    LinkedHashMap<String, String> flashcards = new LinkedHashMap<>();
    HashMap<String, Integer> mistakeCount = new HashMap<>();

    public CardService() {}

    public void addCard(String card, String definition) {
        flashcards.put(card, definition);
        mistakeCount.put(card, 0);
    }

    public void addCardsFromList(List<String> list) {
            list.forEach(str -> {
                String[] arr = str.split(":");
                flashcards.put(arr[0], arr[1]);
                mistakeCount.put(arr[0], Integer.parseInt(arr[2]));
            });
    }

    public void addMistakeCount(String card, int count) {
        mistakeCount.put(card, count);
    }

    public void removeCard(String card) {
        flashcards.remove(card);
    }

    public String getCardDefinition(String key) {
        return flashcards.get(key);
    }

    public String getCardByDefinition(String definition) {
        for (HashMap.Entry<String,String> entry : flashcards.entrySet()) {
            if (entry.getValue().equals(definition)) {
                return entry.getKey();
            }
        }
        return "";
    }

    public HashMap<String, Integer> getHardestCards() {

        HashMap<String, Integer> hardestCards = new HashMap<>();
        int max;

        if (mistakeCount.size() == 0) {
            return hardestCards;
        }

        max = Collections.max(mistakeCount.values());

        if (max == 0) {
            return hardestCards;
        }

        mistakeCount.forEach((key, value) -> {
            if (value == max) {
                hardestCards.put(key, value);
            }
        });

        return hardestCards;
    }

    public void updateMistakeCount(String card) {
        Optional<Integer> opt = Optional.ofNullable(mistakeCount.get(card));
        int numOfMistakes = opt.isEmpty() ? 0 : opt.get();
        mistakeCount.put(card, numOfMistakes + 1);
    }

    public int getNumberOfFlashcards() {
        return flashcards.size();
    }

    public ArrayList<String> getKeyList() {
        return new ArrayList<>(flashcards.keySet());
    }

    public boolean containsCard(String card) {
        return flashcards.containsKey(card);
    }

    public boolean containsDefinition(String definition) {
        return flashcards.containsValue(definition);
    }

    public String allCardsToString() {
        StringBuilder sb = new StringBuilder();

        flashcards.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append(":").append(mistakeCount.get(key)).append("\n");
        });

        return sb.toString();
    }

    public void resetMistakeCount() {
        for (Map.Entry<String, Integer> entry : mistakeCount.entrySet()) {
            entry.setValue(0);
        }
    }
}
