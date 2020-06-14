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
            int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
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