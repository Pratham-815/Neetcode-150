import java.util.HashSet;
import java.util.Set;

/**
 * Solution for LeetCode 128: Longest Consecutive Sequence
 * Time Complexity: O(n) - We iterate through the array twice at most
 * Space Complexity: O(n) - We store all numbers in a HashSet
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        // Store all numbers in a HashSet for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        // Check each number to see if it's the start of a sequence
        for (int num : numSet) {
            // Only process if it's the start of a sequence
            // (i.e., num-1 doesn't exist in the set)
            if (!numSet.contains(num - 1)) {
                int length = 1;

                // Count consecutive numbers by checking if next number exists
                while (numSet.contains(num + length)) {
                    length++;
                }

                // Update longest sequence found so far
                longest = Math.max(longest, length);
            }
        }

        return longest;        
    }
}
