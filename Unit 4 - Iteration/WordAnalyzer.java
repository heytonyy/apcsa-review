public class WordAnalyzer {
    private String word;
    
    /**
     * Constructs a WordAnalyzer object with the given word.
     * @param word the word to analyze
     */
    public WordAnalyzer(String word) {
        this.word = word;
    }
    
    /**
     * Counts the number of vowels (a, e, i, o, u) in the word.
     * @return the number of vowels
     */
    public int countVowels() {
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < word.length(); i++) {
            String character = word.substring(i, i + 1);
            if (vowels.indexOf(character) != -1) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Determines if the word contains consecutive duplicate characters.
     * @return true if the word contains consecutive duplicate characters, false otherwise
     */
    public boolean hasConsecutiveDuplicates() {
        if (word.length() < 2) {
            return false;
        }
        
        for (int i = 0; i < word.length() - 1; i++) {
            String current = word.substring(i, i + 1);
            String next = word.substring(i + 1, i + 2);
            
            if (current.equals(next)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Finds the longest sequence of consecutive equal characters in the word.
     * @return the longest sequence of consecutive equal characters
     */
    public String longestSequence() {
        if (word.length() == 0) {
            return "";
        }
        
        String currentChar = word.substring(0, 1);
        int currentCount = 1;
        
        String maxChar = currentChar;
        int maxCount = currentCount;
        
        for (int i = 1; i < word.length(); i++) {
            String nextChar = word.substring(i, i + 1);
            
            if (nextChar.equals(currentChar)) {
                currentCount++;
                
                if (currentCount > maxCount) {
                    maxChar = currentChar;
                    maxCount = currentCount;
                }
            } else {
                currentChar = nextChar;
                currentCount = 1;
            }
        }
        
        // Construct the longest sequence
        String sequence = "";
        for (int i = 0; i < maxCount; i++) {
            sequence += maxChar;
        }
        
        return sequence;
    }
    
    /**
     * Finds the most frequent character in the word.
     * If there is a tie, returns the first character that reaches the maximum count.
     * @return the most frequent character as a String, or null if no word
     */
    public String mostFrequentChar() {
        if (word.length() == 0) {
            return null;
        }
        
        String mostFrequent = word.substring(0, 1);
        int maxCount = 0;
        
        for (int i = 0; i < word.length(); i++) {
            String current = word.substring(i, i + 1);
            int count = 0;
            
            // Count occurrences of current character
            for (int j = 0; j < word.length(); j++) {
                if (word.substring(j, j + 1).equals(current)) {
                    count++;
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = current;
            }
        }
        
        return mostFrequent;
    }
}