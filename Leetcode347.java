import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Solution for LeetCode 347: Top K Frequent Elements
 * Time Complexity: O(n log k) where n is the length of input array
 * Space Complexity: O(n) for storing elements in HashMap and PriorityQueue
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number using HashMap
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        
        // Step 2: Create max heap (PriorityQueue) based on frequency count
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );
        
        // Step 3: Add all entries to heap
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
        }
        
        // Step 4: Extract top k frequent elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll()).getKey();
        }
        
        return res;        
    }
}
