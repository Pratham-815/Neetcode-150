import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for LeetCode 49: Group Anagrams
 * Problem: Given an array of strings, group anagrams together
 * 
 * Time Complexity: O(n * k) where:
 * n = number of strings in input array
 * k = maximum length of a string in the array
 * 
 * Space Complexity: O(n * k) to store all strings in the HashMap
 */
public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Handle empty input
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store anagram groups: key = frequency count string, value = list of anagrams
        Map<String, List<String>> ansMap = new HashMap<>();
        // Array to store frequency count of characters
        int[] count = new int[26];

        for (String s : strs) {
            // Reset count array for each string
            Arrays.fill(count, 0);
            // Count frequency of each character in current string
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Create unique key using character counts
            // Format: #count1#count2#count3...#count26
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            // Add string to its anagram group in the map
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }
            ansMap.get(key).add(s);
        }

        // Convert map values to result list
        return new ArrayList<>(ansMap.values());
    }
}
