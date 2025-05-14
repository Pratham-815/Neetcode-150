/**
 * Solution for LeetCode 167 - Two Sum II - Input Array Is Sorted
 * Time Complexity: O(n) - where n is the length of the input array
 * Space Complexity: O(1) - only using two pointers, constant extra space
 */
public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers, one at start and one at end
        int left = 0, right = numbers.length-1;
        
        // Use two pointer technique to find pair that sums to target
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                // Return 1-based indices as per problem requirement
                return new int[]{left+1, right+1};
            } else if(sum < target)
                // If sum is too small, move left pointer to increase sum
                left++;
            else
                // If sum is too large, move right pointer to decrease sum
                right--;
        }
        
        // Return [-1,-1] if no solution found (though problem guarantees a solution exists)
        return new int[]{-1, -1};
    }
}
