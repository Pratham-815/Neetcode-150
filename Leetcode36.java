import java.util.HashSet;
import java.util.Set;

/**
 * Solution for LeetCode 36 - Valid Sudoku
 * Time Complexity: O(1) - since we're always iterating through a 9x9 board
 * Space Complexity: O(1) - the HashSet will store at most 81 entries
 */
public class Leetcode36 {
    /**
     * Determines if a 9x9 Sudoku board is valid.
     * A valid board must satisfy:
     * 1. Each row must contain digits 1-9 without repetition
     * 2. Each column must contain digits 1-9 without repetition
     * 3. Each 3x3 sub-box must contain digits 1-9 without repetition
     * 
     * @param board 9x9 Sudoku board
     * @return true if the board is valid, false otherwise
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        // Iterate through each cell in the 9x9 board
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.') {  // Skip empty cells
                    // Try to add unique strings for row, column and block
                    // If any add operation returns false, it means we found a duplicate
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
