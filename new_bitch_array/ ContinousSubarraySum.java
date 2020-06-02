// time: o(n)
// space: o(min(n,k))

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        For anybody is confused about map.put(0,-1);
// In the case nums = [1, 5] k = 6, at i=1, sum % k is 0, so we need a key '0' in the map,
//         and it must be comply with the continuous condition, i - map.get(sum) > 1, 
//         so we give an arbitrary value of -1.
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (k != 0) {
                sum %= k;
            }
            
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            }else{
                map.put(sum,i);
            }
        }
        return false;
    }
}

// 7%3 =1
// 10%3 =1
//     which mean we found the answer they hava same reminder % 3.
//     so subsum between index of 7 and 10 % 3 == 0; we found the answer. 
// a%k = x
// b%k = x
// (a - b) %k = x -x = 0
// here a - b = the sum between i and j.