import java.util.HashSet;

/**
 * LeetCode 217 - Contains Duplicate
 * Problem: Determine if an array contains any duplicate elements
 * Time Complexity: O(n) - where n is the length of input array
 * Space Complexity: O(n) - for storing elements in HashSet
 */
public class Leetcode217 {

    public boolean containsDuplicate(int[] nums) {
        // HashSet to store unique numbers we've seen
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterate through each number in the array
        for(int num: nums){
            // If number is already in set, we found a duplicate
            if(seenNumbers.contains(num)){
                return true;
            }
            // Add current number to set
            seenNumbers.add(num);
        }

        // No duplicates found after checking all numbers
        return false;
    }
}