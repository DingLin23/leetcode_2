//time:O(n)
//space:O(n)

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0,sum = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < A.length; i++) {
                sum += A[i];
            if (K != 0) {
                sum %= K;
            }
            sum  = sum < 0 ? sum+K : sum; //如果负数的话余数会不一样
            res += map.getOrDefault(sum,0);
            map.put(sum, map.getOrDefault(sum,0) +1);
        }
        return res;
    }
}