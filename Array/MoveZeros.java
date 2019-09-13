//time:o(n)
//space:o(1)

class Solution {
        // num of operation : nums.length;
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
                //nums[start]=nums[i];
                //start++;
               
            }
        }
        while (start < nums.length) {
            nums[start++] = 0;
        }
    }

        // num of operation : 2 * num of non-zero
    // lots of zeros
    public void  moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}