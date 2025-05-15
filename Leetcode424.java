import java.util.HashMap;

public class Leetcode424 {
    /**
     * Leetcode 424: Longest Repeating Character Replacement
     * Given a string s and an integer k, find the length of the longest substring containing
     * the same letter after replacing at most k characters.
     *
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) as the HashMap will store at most 26 characters (English alphabet)
     */
    public int characterReplacement(String s, int k) {
        int windowStart = 0, maxLength = 0, mostRepeatingCharCount = 0;
        
        // Map to store frequency of characters in current window
        HashMap<Character, Integer> charFreqMap = new HashMap();
        
        // Sliding window approach
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            // Add new character to window and update frequency
            char right = s.charAt(windowEnd);
            charFreqMap.put(right, charFreqMap.getOrDefault(right, 0)+1);
            
            // Track count of the most frequent character in current window
            mostRepeatingCharCount = Math.max(mostRepeatingCharCount, charFreqMap.get(right));
            
            // If number of characters to be replaced > k, shrink window
            while(windowEnd-windowStart+1 - mostRepeatingCharCount > k) {
                char left = s.charAt(windowStart);
                charFreqMap.put(left, charFreqMap.get(left)-1);
                if(charFreqMap.get(left) == 0)
                    charFreqMap.remove(left);
                windowStart++;
            }
            
            // Update maximum length found so far
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        
        return maxLength;
    }
}
