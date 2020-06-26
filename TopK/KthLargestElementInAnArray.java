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
//time:o(n^2),best O(n)
//space:o(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
       int lo = 0;
       int hi = nums.length-1;
       while (lo < hi) {
           int pos = partition(nums, lo, hi);
           if (pos == k) {
               return nums[pos];
           } else if (pos < k) {
               lo = pos+1;
           } else {
               hi = pos-1;
           }
       }
       return nums[lo];
   }


   private int partition(int[] nums, int lo, int hi) {
       int pivot = nums[lo];
       while (lo < hi) {
           while (lo < hi && nums[hi] >= pivot) hi--;
           nums[lo] = nums[hi];
           while (lo < hi && nums[lo] <= pivot) lo++;
           nums[hi] = nums[lo];
       }
       nums[lo] = pivot;
       return lo;

    }
}