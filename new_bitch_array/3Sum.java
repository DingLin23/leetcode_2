import java.util.*;
//time:o(nlgn)
//space; o(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
            continue;
        }
        int l = i + 1, r = nums.length - 1;  
        int target = -nums[i];
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) l++;  // skip same result
                while (l < r && nums[r] == nums[r + 1]) r--;  // skip same result
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
    }
    return res;
    }
}