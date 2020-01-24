//time:o(n)
//space:o(k)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return new int[0];
        int [] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        
        while(i < nums.length){
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            
            if(i >= k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
            i++;
        }
        return res;
    }
}