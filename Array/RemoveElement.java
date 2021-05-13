//time:O(n)
//space:O(1)

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (num != val) {
                nums[count++] = num; // count how many num != value, size of nums.length we want. if not same keep the original num;
            }
        }
        return count;
    }
}
