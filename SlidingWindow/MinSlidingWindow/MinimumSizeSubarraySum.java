//time: O(n)
//space:O(1)

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int minLeft = 0;
        int minRight = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (i <= j && sum >= s) {
                int currL = j-i+1;
                sum -= nums[i];
                if (currL < min) {
                    min = currL;
                    minLeft = i;
                    minRight = j;
                }
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
