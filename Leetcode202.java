/**
 * LeetCode 202: Happy Number
 * Time Complexity: O(log n) - The number of digits reduces logarithmically
 * Space Complexity: O(1) - Only using constant extra space
 */
public class Leetcode202 {
    /**
     * Determines if a number is happy using Floyd's Cycle-Finding Algorithm
     * A happy number is one where the sum of squares of its digits eventually equals 1
     * If it's not happy, it will enter a cycle
     */
    public boolean isHappy(int n) {
        // Using two pointers (Floyd's Cycle-Finding Algorithm)
        int slow = n, fast = n;
        do {
            slow = sum(slow);            // Move slow pointer one step
            fast = sum(sum(fast));       // Move fast pointer two steps
        } while(slow != fast);           // Continue until cycle is detected
        
        return slow == 1;                // If cycle ends at 1, it's a happy number
    }
    
    /**
     * Helper method to calculate sum of squares of digits
     * @param n number to process
     * @return sum of squares of digits
     */
    private int sum(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;          // Extract last digit
            sum += (digit*digit);        // Add square of digit
            n /= 10;                     // Remove last digit
        }
        return sum;
    }
}
