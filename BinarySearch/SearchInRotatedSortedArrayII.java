// time:o(lgn)
//space:o(1)
class solution{
public boolean search(int[] nums, int target) {
    if (nums.length == 0) {
        return false;
    }
    int lo = 0;
    int hi = nums.length-1;
    while (lo+1<hi) {
        int mid = lo+(hi-lo)/2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] == nums[hi]) {
            hi--;
        } else if (nums[mid] < nums[hi]) {
            if (nums[mid] < target && target <= nums[hi]) {
                lo = mid;
            } else {
                hi = mid;
            }
        } else {
            if (nums[lo] <= target && target < nums[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
    }
    return nums[lo] == target || nums[hi] == target;
}
}
