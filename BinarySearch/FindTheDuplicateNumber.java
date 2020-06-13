// time:o(n)
//space:o(n)
    class Solution {
        public int findDuplicate(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int res =0;
            for (int i : nums) {
                map.put(i,map.getOrDefault(i,0)+1);
                if (map.get(i) == 2)  res =i;
            }return res;
        }
    }

//time:o(nlgn)
//space: o(1)
    class Solution {
        public int findDuplicate(int[] nums) {
            Arrays.sort(nums);
            int res = -1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) {
                    res = nums[i];
                }
            }
            return res;
        }
    }