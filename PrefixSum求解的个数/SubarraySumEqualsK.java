//time:O(n)
//space:O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // if case have sum - k == 0, we need count 1;
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0); // 因为这题比较特殊可以这么写，如果遇到对的值就加上它的count，没有就加上0；
            map.put(sum, map.getOrDefault(sum, 0) + 1); // if find the same sum count++; 
        }
        return res;  
    }
}