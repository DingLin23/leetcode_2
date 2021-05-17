class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE; // 可以直接用-1；题目说不符合标准的话直接用-1；
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum >= k) { // >= 都不行，只有小于可以。
                hi--;
            }
            else {
                lo++;
                max = Math.max(max,sum);
            }
        }
        return max == Integer.MIN_VALUE? -1 : max;
    }
}
