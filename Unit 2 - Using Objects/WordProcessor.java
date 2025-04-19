public class WordProcessor {
    private String text;
    
    /**
     * Constructs a new WordProcessor with empty text.
     */
    public WordProcessor() {
        text = "";
    }
    
    /**
     * Sets the text of this WordProcessor.
     * @param newText the new text content
     */
    public void setText(String newText) {
        if (newText == null) {
            text = "";
        } else {
            text = newText;
        }
    }
    
    /**
     * Counts occurrences of a word in the text.
     * @param word the word to count
     * @return the number of occurrences
     */
    public int countWord(String word) {
        if (word == null || word.isEmpty() || text.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        int index = 0;
        
        // Convert to lowercase for case-insensitive matching
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();
        
        while (index < lowerText.length()) {
            index = lowerText.indexOf(lowerWord, index);
            if (index == -1) {
                break;
            }
            
            // Check if it's a whole word by checking boundaries
            boolean leftBoundary = (index == 0 || !Character.isLetter(lowerText.charAt(index - 1)));
            boolean rightBoundary = (index + lowerWord.length() == lowerText.length() || 
                                   !Character.isLetter(lowerText.charAt(index + lowerWord.length())));
            
            if (leftBoundary && rightBoundary) {
                count++;
            }
            
            index += lowerWord.length();
        }
        
        return count;
    }
    
    /**
     * Replaces all occurrences of a word with another word.
     * @param target the word to replace
     * @param replacement the replacement word
     * @return the resulting text after replacement
     */
    public String replaceWord(String target, String replacement) {
        if (target == null || target.isEmpty() || text.isEmpty()) {
            return text;
        }
        
        if (replacement == null) {
            replacement = "";
        }
        
        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(target)) {
                result.append(replacement);
            } else {
                result.append(words[i]);
            }
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    /**
     * Gets statistics about the text.
     * @return an array containing [wordCount, characterCount]
     */
    public int[] getStatistics() {
        int[] stats = new int[2];
        
        if (text.isEmpty()) {
            return stats;
        }
        
        // Character count (excluding spaces)
        String noSpaces = text.replace(" ", "");
        stats[1] = noSpaces.length();
        
        // Word count
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            stats[0] = 0;
        } else {
            String[] words = trimmed.split("\\s+");
            stats[0] = words.length;
        }
        
        return stats;
    }
    
    /**
     * Gets the current text.
     * @return the text
     */
    public String getText() {
        return text;
    }
}