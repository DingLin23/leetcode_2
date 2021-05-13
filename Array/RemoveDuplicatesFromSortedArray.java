class Solution {
    public int removeDuplicates(int[] nums) {
        int count = nums.length > 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
