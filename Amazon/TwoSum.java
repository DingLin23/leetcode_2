//time:o(n)
//space:o(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[] {-1,-1};
        int[] res = new int[] {-1,-1};
        Map <Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
           map.put(nums[i],i); //have to put in this place one case will not pass.
        }
        return res;
        
   }
}