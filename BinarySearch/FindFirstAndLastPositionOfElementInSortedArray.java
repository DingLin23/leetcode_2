//Time: O(lgn)
//space: o(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums.length == 0 || nums == null) return res;
        int left = 0, right = nums.length-1;
        
        res[0] = findFirst(nums,target,left,right);
        res[1] = findLast(nums,target,left,right);
        return res;           
        }
        
        private int findFirst(int[] nums, int target, int left, int right) {
            while (left+1 < right) {
            int mid = left + (right - left)/2;
                // if (nums[mid] == target) {  // 不可以这么写，因为，找到后，还要往前，或则往后找。
                //     return mid;
                // }
                if (nums[mid] >= target) { // duplicate staff, 找到mid了后，继续往左二分。
                    right = mid;
                }else {
                    left = mid;
                }
            }
            
            if (nums[left] == target) return left;
            else if (nums[right] == target) return right;
            else return -1;
        }
        
        private int findLast(int[] nums, int target, int left, int right) {
            while (left+1 < right) {
            int mid = left + (right - left)/2;

                if (nums[mid] <= target) { // duplicate staff, 找到mid了后，继续往右二分。
                    left = mid;
                }else {
                    right = mid;
                }
            }
            
            if (nums[right] == target) return right;//必须要先输出right，因为left index 在findFirst先找到了。 if has input[2,2] will be wrong, if return left first;
            else if (nums[left] == target) return left;
            else return -1;
        } 
}




