import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76: Minimum Window Substring
 * Time Complexity: O(n), where n is the length of string s
 * Space Complexity: O(k), where k is the number of unique characters in strings s and t
 */
public class Leetcode76 {
    public String minWindow(String s, String t) {
        int winS = 0, winE = 0; // Window start and end pointers
        String ans = ""; // Store the minimum window substring
        
        // Maps to store character frequencies
        Map<Character, Integer> tMp = new HashMap<>(); // For target string t
        Map<Character, Integer> wMp = new HashMap<>(); // For current window
        
        // Count frequencies of characters in string t
        for(char c : t.toCharArray()) {
            tMp.put(c, tMp.getOrDefault(c, 0)+1);
        }
        
        // Sliding window approach
        while(winS < s.length() && winE < s.length()) {
            // Add current character to window map
            char c = s.charAt(winE);
            wMp.put(c, wMp.getOrDefault(c, 0)+1);
            
            // Try to minimize window size while maintaining valid substring
            while(winS <= winE && satisfy(wMp, tMp)) {
                // Update answer if this is first valid window or smaller than current answer
                if(ans == "")
                    ans = s.substring(winS, winE+1);
                ans = (winE-winS+1) < ans.length() ? s.substring(winS, winE+1) : ans;
                
                // Remove leftmost character from window
                wMp.put(s.charAt(winS), wMp.get(s.charAt(winS))-1);
                if(wMp.get(s.charAt(winS)) == 0)
                    wMp.remove(s.charAt(winS));
                winS++;
            }
            winE++;
        }
        return ans;
    }

    /**
     * Checks if window map contains all characters from target map with required frequencies
     * @param wMp Window character frequency map
     * @param tMp Target character frequency map
     * @return true if window contains all required characters
     */
    private boolean satisfy(Map<Character, Integer> wMp, Map<Character, Integer> tMp) {
        for(char c : tMp.keySet()) {
            if(!wMp.containsKey(c) || wMp.get(c) < tMp.get(c))
                return false;
        }
        return true;
    }
}
