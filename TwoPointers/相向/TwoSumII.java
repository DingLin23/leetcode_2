//time: o(n)
//space: o(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return  new int[]{};
        int lo = 0, hi = numbers.length-1;

        
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[]{lo+1,hi+1};
            }else if (sum > target) {
                hi--;
            }else {
                lo++;
            }
        }
        
        return new int[]{lo+1,hi+1};
    }
}


