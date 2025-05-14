import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for 3Sum problem (LeetCode 15)
 * Time Complexity: O(n^2) - One loop (n) and two pointer technique (n)
 * Space Complexity: O(1) - Not counting the space used for output
 */
public class Leetcode15 {
    /**
     * Finds all unique triplets in the array that sum to zero
     * @param nums input array
     * @return list of triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort array to handle duplicates and use two pointer technique
        Arrays.sort(nums);
        
        // Fix first element and find other two elements using two pointers
        for(int i = 0; i < nums.length-2; i++) {
            // Skip duplicates for first element
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            search(i, nums, result);
        }
        return result;
    }
    
    /**
     * Helper method to find pairs that sum up with nums[index] to zero
     * Uses two pointer technique to find the pairs
     */
    private void search(int index, int[] nums, List<List<Integer>> result) {
        int left = index+1, right = nums.length-1;
        
        while(left < right) {
            int sum = nums[index] + nums[left] + nums[right];
            if(sum == 0) {
                // Found a valid triplet
                result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                left++;
                right--;
                // Skip duplicates for second element
                while(left < right && nums[left]==nums[left-1])
                    left++;
                // Skip duplicates for third element
                while(left < right && nums[right]==nums[right+1])
                    right--;
            } else if(sum < 0) {
                // Sum too small, increment left pointer
                left++;
            } else {
                // Sum too large, decrement right pointer
                right--;
            }
        }
    }
}
