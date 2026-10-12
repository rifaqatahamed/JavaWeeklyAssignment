import java.util.HashMap;
import java.util.Map;
public class StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");
        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isStopWord = false;
            for (int j = 0; j < stopWords.length; j++) {
                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }
            if (isStopWord) {
                continue;
            }
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }
        while (!frequency.isEmpty()) {
            String highestWord = null;
            int highestCount = 0;
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry.getValue() > highestCount) {
                    highestWord = entry.getKey();
                    highestCount = entry.getValue();
                }
            }
            System.out.println(highestWord + ": " + highestCount);
            frequency.remove(highestWord);
        }
    }
    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}