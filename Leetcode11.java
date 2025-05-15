/**
 * Solution for Container With Most Water (LeetCode 11)
 * Time Complexity: O(n) - where n is the length of input array
 * Space Complexity: O(1) - only using constant extra space
 */
public class Leetcode11 {
    /**
     * Finds the container that can hold the maximum amount of water
     * Uses two-pointer technique to find the maximum area
     * @param height array representing heights of vertical lines
     * @return maximum area that can be contained between two lines
     */
    public int maxArea(int[] height) {
        int area = 0, maxArea = 0;
        int left = 0, right = height.length-1;
        
        // Use two pointers to traverse from both ends
        while(left < right) {
            // Calculate area using width (right-left) * minimum height
            area = Math.min(height[left], height[right])*(right-left);
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer with smaller height inward
            // as it's the limiting factor for area
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
