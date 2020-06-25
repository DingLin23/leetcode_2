//time:O(n)
//space:o(n)

class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0, count = 0;
        if (nums == null || nums.length == 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        
        map.put(0,-1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
            count += nums[i];
            if (map.containsKey(count)) {
                res = Math.max(res, i- map.get(count));
            }
            map.putIfAbsent(count,i);
        }
        return res;
    }
}