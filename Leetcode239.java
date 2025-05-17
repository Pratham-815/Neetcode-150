import java.util.ArrayDeque;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int wS = 0, s = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int wE = 0; wE < nums.length; wE++) {
            // while the element at the first of the queue, i.e the index,
            // if it's out of the window, keep removing the element
            while(!q.isEmpty() && q.peekFirst() <= wE-k)
                q.pollFirst();
            
            // while the element at the last of the queue, i.e the index,
            // if it's less than equal to new element of the nums,
            // keep removing the element
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[wE])
                q.pollLast();
          
            // insert the index of new element of nums
            q.offerLast(wE);
            
            // if wE greater than k-1, then add the first element
            // (index of the element in nums) of the queue to res
            if(wE >= k-1)
                res[s++] = nums[q.peekFirst()];
        }
        return res;
    }
}
