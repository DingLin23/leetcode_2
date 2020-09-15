//time: o(lgn)
//space: o(1)

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            
            //mid -> right is sorted
            if (nums[mid] < nums[right]) {
                //to check if target in it or not;
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                }else {
                    right = mid;
                }
            }else if (nums[mid] > nums[left]) { // left-> mid is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }
        }
        
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}