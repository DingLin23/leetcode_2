// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

// Example 1:

// Input:nums = [1,1,1], k = 2
// Output: 2
 

// Constraints:

// The length of the array is in range [1, 20,000].
// The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

//bruce force
//time: o(n^3)
//spcae: o(1)
class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++){
            for (int end = start+1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[start];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }
}

//create an array sum to store cumulative sum
//time:o(n^2)
//space:o(n)
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum [] = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                if(k == sum[end]-sum[start]) count++;
            }
        }
        return count;
    }
}

// constant space
//time:0(n^2)
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (k == sum) count++;
            }
        }
        return count;
    }
}


//hashmap 
//time:o(n)
//space: o(n)
public class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1); //  就是sum-k == 0 等于key的话，就get value 1. which count+1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}