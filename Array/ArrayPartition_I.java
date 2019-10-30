
//time:o(nlgn)
//space:o(1);

class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length % 2 != 0 || nums ==  null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}