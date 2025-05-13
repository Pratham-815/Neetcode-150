/**
 * Solution for LeetCode 238: Product of Array Except Self
 * Time Complexity: O(n) - Two passes through the array
 * Space Complexity: O(1) - Only using the output array, no extra space
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; // Result array to store products
        
        // First pass: Calculate prefix products from left to right
        int pre = 1;
        res[0] = 1;
        for(int i = 0; i < n-1; i++) {
            pre *= nums[i];         // Accumulate product from left
            res[i+1] = pre;         // Store prefix product
        }
        
        // Second pass: Calculate suffix products from right to left
        // and multiply with prefix products
        int post = 1;
        for(int i = n-1; i > 0; i--) {
            post *= nums[i];        // Accumulate product from right
            res[i-1] *= post;       // Multiply with existing prefix product
        }
        
        return res;
    }
}
