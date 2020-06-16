//time:o(n)
//space: o(1)

class Solution {
    public int maxArea(int[] height) {
        //木桶原理，双指针
        int res = 0;
        if (height == null || height.length == 0) {
            return res;
        }
        
        int left = 0, right = height.length-1;
        
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right-left));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}