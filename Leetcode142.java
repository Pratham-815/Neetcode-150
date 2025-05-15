/**
 * LeetCode 42: Trapping Rain Water
 * Using Two Pointer Approach
 * Time Complexity: O(n) - where n is the length of height array
 * Space Complexity: O(1) - only using constant extra space
 */
public class Leetcode142 {

    /**
     * Calculates the amount of water that can be trapped between the bars
     * @param height Array representing heights of bars
     * @return Total units of water trapped
     */
    public int trap(int[] height) {
        // Initialize two pointers and maximum heights from both sides
        int left = 0, right = height.length-1;
        int lMax = height[0], rMax = height[right];
        int ans = 0;

        while(left <= right) {
            if(lMax <= rMax) {
                // Update the maximum height from left side
                lMax = Math.max(lMax, height[left]);
                // Calculate water trapped at current position
                int val = Math.min(lMax, rMax)-height[left];
                // Add to result if positive value
                ans += val < 0 ? 0 : val;
                left++;
            } else {
                // Update the maximum height from right side
                rMax = Math.max(rMax, height[right]);
                // Calculate water trapped at current position
                int val = Math.min(lMax, rMax)-height[right];
                // Add to result if positive value
                ans += val < 0 ? 0 : val;
                right--;
            }
        }       
        return ans;
    }
}