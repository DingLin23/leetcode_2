//time: o(n)
//space:o(n)

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0){ // integer，可以是负数
                sum %= k;
            }
            if (map.containsKey(sum) && i-map.get(sum) >=2) {
                    return true;
            }
            map.putIfAbsent(sum,i);
        }
        return false;
    }
}