import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 659: Split Array into Consecutive Subsequences
 * Time Complexity: O(n log k), where n is length of nums array and k is number of subsequences
 * Space Complexity: O(k), where k is number of subsequences
 */

record SubSeq(int start, int end) {};

public class Leetcode659 {
    public boolean isPossible(int[] nums) {
        // Priority Queue to store subsequences, ordered by end value and length
        PriorityQueue<SubSeq> subsequences = new PriorityQueue<>((SubSeq subseq1, SubSeq subseq2) -> {
            // If end values are equal, shorter subsequence gets priority
            // Otherwise, subsequence with smaller end value gets priority
            return (subseq1.end() == subseq2.end()) 
                ?
                (subseq1.end() - subseq1.start()) - (subseq2.end() - subseq2.start()) 
                :
                (subseq1.end() - subseq2.end());
        });

        // Iterate through each number in the input array
        for (int num : nums) {
            // Remove subsequences that can't be extended by current number
            while (!subsequences.isEmpty() && subsequences.peek().end() + 1 < num) {
                if(!isValid(subsequences)) {
                    return false;
                }
            }

            // If queue is empty or top subsequence ends with current number,
            // start a new subsequence
            if (subsequences.isEmpty() || subsequences.peek().end() == num) {
                subsequences.add(new SubSeq(num, num));
            } else {
                // Extend the existing subsequence by adding current number
                SubSeq currentSubsequence = subsequences.poll();
                subsequences.add(new SubSeq(currentSubsequence.start(), num));
            }
        }

        // Check if all remaining subsequences are valid (length >= 3)
        while (!subsequences.isEmpty()) {
            if(!isValid(subsequences)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Calculate length of a subsequence
     * @param seq the subsequence
     * @return length of the subsequence
     */
    int getSequenceLength(SubSeq seq) {
        // Example: seq: [6,7,8] => start: 6, end: 8 => length: 8-6+1 = 3
        return seq.end() - seq.start() + 1;
    }

    /**
     * Check if a subsequence is valid (length >= 3)
     * @param subsequences queue containing subsequences
     * @return true if subsequence length is greater than 2
     */
    boolean isValid(Queue<SubSeq> subsequences) {
        SubSeq currentSubsequence = subsequences.poll();
        int subsequenceLength = getSequenceLength(currentSubsequence);
        return subsequenceLength > 2;
    }
}
