//time:O(nlgn)
//space:O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
}