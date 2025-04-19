public class PatternChecker {
    
    public static boolean checkPattern(String str) {
        // Call the helper method with starting prefix length 1
        return checkPatternHelper(str, 1);
    }
    
    private static boolean checkPatternHelper(String str, int prefixLength) {
        // Base cases
        if (str.length() == 0) {
            return true; // Empty string follows pattern
        }
        
        if (prefixLength > str.length()) {
            return false; // Prefix is longer than string, no pattern possible
        }
        
        // Get the current prefix to test
        String prefix = str.substring(0, prefixLength);
        
        // Check if the entire string can be formed using this prefix
        if (str.length() % prefixLength == 0) {
            // Check each block
            boolean validPattern = true;
            
            for (int i = 0; i < str.length(); i += prefixLength) {
                if (!str.substring(i, i + prefixLength).equals(prefix)) {
                    validPattern = false;
                    break;
                }
            }
            
            if (validPattern) {
                return true;
            }
        }
        
        // If the current prefix doesn't work, try a longer prefix
        return checkPatternHelper(str, prefixLength + 1);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(checkPattern("abcabc")); // true
        System.out.println(checkPattern("xxxxxx")); // true
        System.out.println(checkPattern("abcdabcd")); // true
        System.out.println(checkPattern("abc")); // true
        System.out.println(checkPattern("abcde")); // false
        System.out.println(checkPattern("abcdeabc")); // false
    }
}