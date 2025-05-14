/**
 * Problem: Valid Palindrome
 * Determines if a string is a palindrome considering only alphanumeric characters and ignoring case
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1) as we only use two pointers
 */
public class Leetcode125 {
    public boolean isPalindrome(String s) {
        // Initialize two pointers, one at start and one at end
        int i = 0, j = s.length()-1;
        
        while(i < j) {
            // Skip non-alphanumeric characters from left
            while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            // Skip non-alphanumeric characters from right
            while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            
            // Compare characters after converting to lowercase
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            
            // Move pointers towards center
            i++;
            j--;
        }
        
        return true;
    }
}
