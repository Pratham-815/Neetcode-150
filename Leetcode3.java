import java.util.HashMap;
import java.util.Map;

/**
 * Solution for Leetcode 3: Longest Substring Without Repeating Characters
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(min(m,n)) where m is the size of the character set
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        // Map to store character and its last seen position
        Map<Character, Integer> mp = new HashMap<>();
        // maxLen tracks the longest substring length
        // winStart is the start of current window
        int maxLen = 0, winStart = 0;
        
        // Iterate through the string using sliding window approach
        for(int winEnd = 0; winEnd < s.length(); winEnd++) {
            char ch = s.charAt(winEnd);
            // If character is already seen, move window start
            // to the next position of last occurrence
            if(mp.containsKey(ch)) {
                winStart = Math.max(winStart, mp.get(ch)+1);
            }
            // Update character's position in map
            mp.put(ch, winEnd);
            // Update maximum length if current window is larger
            maxLen = Math.max(winEnd - winStart + 1, maxLen);
        }
        return maxLen;        
    }
}
