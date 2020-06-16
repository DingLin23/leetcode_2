//time:O(n)
//space:O(n)

class Solution {
    public int findPairs(int[] nums, int k) {
       // HashMap<Element, Frequency>
        if(nums == null || nums.length == 0 || k < 0) return 0;
        
        //1. Iterate on the map to avoid duplicate: [1,1,3,4,5] ->map: 1,3,4,5
        //2. Only count (element+k) to avoud duplicate: (1, 2) k = 1; only calculate 1 + 1 = 2, never calculate 2 - 1 = 1;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) 
            map.put(n, map.getOrDefault(n, 0) + 1);
        for(int key : map.keySet()) {
            if(k == 0) {
                if(map.get(key) >= 2) 
                    res ++;
            }
            else {
                if(map.containsKey(key + k))
                    res ++;
               
            }
        }
        return res;
    }
}