//time:O(nlgn)
//space:O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
}

//time:O(nlgk)
//space:O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
         Queue<Integer> pq = new PriorityQueue<>();
         for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) { //因为是第k个，所以只要比较比k多一个，最小的去掉。
               pq.poll();
            }
        }
    return pq.peek(); // min on the top, peek 就是答案
    }
}