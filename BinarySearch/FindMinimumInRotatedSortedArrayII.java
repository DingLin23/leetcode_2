//time:O(lgn)
//space:o(1)
//testcase: [3,3,1,3];

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, high = nums.length -1;
        while(lo < high) {
            int mid = (lo+high) >>> 1;
            if (nums[mid] > nums[high]) {
                lo = mid+1;
            }
            else if (nums[mid] == nums[high]) {
                high--;
            }
            else {
                high = mid;
            }
    }
         return nums[lo];
    }
}