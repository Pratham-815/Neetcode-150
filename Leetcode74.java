public class Leetcode74 {
    /**
     * Search in a 2D matrix using a linear approach starting from top-right corner
     * Time Complexity: O(m + n) where m is number of rows and n is number of columns
     * Space Complexity: O(1) as we only use constant extra space
     * 
     * Approach: Start from top-right and move left if current value is too large,
     * or move down if current value is too small
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;
        
        while(row >= 0 && row < m && col >= 0 && col < n) {
            int val = matrix[row][col];
            if(val == target)
                return true;
            else if(val < target)
                row++;    // Move down if current value is smaller
            else
                col--;    // Move left if current value is larger
        }
        return false;
    }
    
    /**
     * Search in a 2D matrix using binary search by treating it as a 1D sorted array
     * Time Complexity: O(log(m*n)) where m is number of rows and n is number of columns
     * Space Complexity: O(1) as we only use constant extra space
     * 
     * Approach: Convert 2D coordinates to 1D index using division and modulo,
     * then perform standard binary search
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            // Convert 1D index to 2D coordinates: row = mid/n, col = mid%n
            int val = matrix[mid/n][mid%n];
            if(val == target)
                return true;
            else if(val < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}
