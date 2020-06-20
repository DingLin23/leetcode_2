//time: o(lgn)
//space: o(1)

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
           return -1;
       }

       int lo = 0;
       int hi = nums.length-1;
        return bs(nums,lo,hi,target);
    }
    private int bs(int[]nums, int lo, int hi,int target){
       while (lo+1<hi) {
           int mid = lo+(hi-lo)/2;
           if (nums[mid] == target) {
               return mid;
           }
           if (nums[mid] < nums[hi]) { // right sorted 
               if (nums[mid] < target && target <= nums[hi]) {
                   lo = mid;
               } else {
                   hi = mid;
               }
           } else if (nums[lo] < nums[mid]) { // left sorted
               if (nums[lo] <= target && target < nums[mid]) {
                   hi = mid;
               } else {
                   lo = mid;
               }
           }
       }

       if (nums[lo] == target) {
           return lo;
       } else if (nums[hi] == target) {
           return hi;
       } else {
           return -1;
       }
    }
   


}