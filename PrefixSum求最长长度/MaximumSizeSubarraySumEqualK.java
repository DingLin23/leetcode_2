//time:O(n)
//space:O(n)

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0, sum = 0;
        
        Map <Integer,Integer> map = new HashMap<>();
        map.put(0,-1); //cover 从0index开始，需要+1 最后return的时候。
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                res = Math.max(res,i-map.get(sum-k));
            }
            map.putIfAbsent(sum,i);
        }
        return res;
    }
}