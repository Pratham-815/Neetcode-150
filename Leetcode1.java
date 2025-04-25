import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode 1 - Two Sum
 * Time Complexity: O(n) - where n is the length of the input array
 * Space Complexity: O(n) - as we store at most n elements in the HashMap
 */
public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array once
        for(int i=0; i<nums.length; i++){
            // Calculate the complement needed to reach target
            int complement = target - nums[i];

            // If complement exists in map, we found our pair
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            // Add current number and its index to map
            map.put(nums[i], i);
        }

        // Return empty array if no solution is found
        return new int[] {};
    }
}
