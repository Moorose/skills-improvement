import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    private boolean LOG;
    private Pattern PATTERN;

    Service() {
        this(false);
    }

    Service(boolean log) {
        LOG = log;
        PATTERN = Pattern.compile("[аеёиоуыэюя]");
    }

    List<String> getWords(String str) {
        List<String> wordList = splitString(str);
        wordList = getCorrectWords(wordList);
        wordList = notTooFastComparator(wordList);

        return wordList;
    }

    private List<String> getCorrectWords(List<String> wordList) {
        int length = wordList.size();
        int wordLength[] = new int[length];
        int max = 0;
        List<String> matchWord = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            wordLength[i] = matchVowel(wordList.get(i));
            max = max < wordLength[i] ? wordLength[i] : max;
        }
        for (int i = 0; i < length; i++) {
            if (wordLength[i] == max) matchWord.add(wordList.get(i));
        }
        logger("Max vowel: " + max);
        logger(matchWord.toString());
        return matchWord;
    }

    private int matchVowel(String input) {
        Matcher matcher = PATTERN.matcher(input);
        int countMatches = 0;
        while (matcher.find())
            countMatches++;
        return countMatches;
    }

    private List<String> splitString(String str) {
        str = str.toLowerCase();
        String[] wordMas = str.split("\\s*(\\s|,|!|\\.)\\s*");
        return new ArrayList<>(Arrays.asList(wordMas));
    }

    private List<String> notTooFastComparator(List<String> wordList) {
        if (wordList.size() == 1) return wordList;
        int count = 0;

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (compareWord(wordList.get(i), wordList.get(j))) {
                    String buf = wordList.get(i);
                    wordList.set(i, wordList.get(j));
                    wordList.set(j, buf);
                }
                count++;
            }
        }
        logger("Count sort: " + count);
        return wordList;
    }

    private boolean compareWord(String word1, String word2) {
        int length = word1.length() < word2.length() ? word1.length() : word2.length();
        boolean equalParts = false;

        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                equalParts = true;
            } else if (word1.charAt(i) > word2.charAt(i) & (equalParts || i == 0)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void logger(String str) {
        if (!LOG) return;
        System.out.println(str);
    }
}