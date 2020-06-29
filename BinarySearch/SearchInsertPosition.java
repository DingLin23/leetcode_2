//time:o(lgn)
//space:o(1)
//test case :[3,5,5,5,5] 5  return 2; 返回最靠前的。
class Solution {
    public int searchInsert(int[] nums, int target) {

        int right = nums.length;

        if (right == 0) {
            return 0;
        }
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


//time:o(nlgn)
//space:o(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
    while (low <= high) {
        int mid = (low + high) >>> 1;
        int cnt = 0;
        for (int a : nums) {
            if (a <= mid) ++cnt;
        }
        if (cnt <= mid) low = mid + 1;
        else high = mid-1;
    }
    return low;
    }
        
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length-1;
        
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid;
            }else {
                left = mid;
            }
        }
        if (nums[left] >= target) return left; //因为在左边界sorted， 所以只要先判断left是否大于target.
        else if (nums[right] >= target) return right; //如果left小于target，然后判断是否应该在中间
        return right+1; //如果大于left和right就加在下一个。
    }
}