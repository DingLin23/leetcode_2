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

//time:O(nlgn)
//space:o(1)
class Solution {
    public int findDuplicate(int[] nums) {
       int lo = 1;
       int hi = nums.length-1;
       while (lo+1<hi) {
           int mid = lo+(hi-lo)/2;
           if (check(nums, mid)) {
               lo = mid;
           } else {
               hi = mid;
           }
       }
       if (check(nums, lo)) {
           return hi;
       } else {
           return lo;
       }
   }


   // check if there are "target" number of elements <= target
   // if true, the duplicate number must be to the right of the target number
   // if false, the duplicate number must be to the left of the target number (or the target number itself)
    // 原理就是去找某一阶段，或则某一节它是sorted的。
   private boolean check(int[] nums, int target) {
       int cnt = 0;
       for (int num : nums) {
           if (num <= target) {
               cnt++;
           }
       }
       return cnt <= target;
   }
}

//Time:o(n)
//space:o(1)
//find a circle

    class Solution {
        public int findDuplicate(int[] nums) {
          if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
    
            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;  
        }
            
    }