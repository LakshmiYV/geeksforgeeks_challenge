import java.util.*;

class Solution {
    public String longestString(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        
        Arrays.sort(words, (a, b) -> {
            if (b.length() != a.length()) {
                return b.length() - a.length(); // Longer words first
            } else {
                return a.compareTo(b); // Lexicographically smaller first
            }
        });

        for (String word : words) {
            boolean allPrefixesPresent = true;
            for (int i = 1; i < word.length(); i++) {
                if (!wordSet.contains(word.substring(0, i))) {
                    allPrefixesPresent = false;
                    break;
                }
            }
            if (allPrefixesPresent) {
                return word;
            }
        }
        
        return ""; // If no valid word found
    }
}

