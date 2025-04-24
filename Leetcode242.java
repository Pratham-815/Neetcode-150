/**
 * Solution for LeetCode 242: Valid Anagram
 * Time Complexity: O(n) where n is the length of the strings
 * Space Complexity: O(1) since we use a fixed size array of 26 characters
 */
public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams
        if(s.length() != t.length()){
            return false;
        }

        // Array to store count of each character (a-z)
        // Index 0 represents 'a', 1 represents 'b', and so on
        int[] charCounts = new int[26];

        // Iterate through both strings simultaneously
        // Increment count for chars in s and decrement for chars in t
        for(int i=0; i<s.length(); i++){
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        // If any count is non-zero, strings are not anagrams
        for(int count: charCounts){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}
