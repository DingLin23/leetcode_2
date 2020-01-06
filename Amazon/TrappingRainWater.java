//time:o (n)
//space: o(1)

// two pointer

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                //from compare with preleft from left to right if val is different then subtract to get res.
                leftMax = Math.max(height[left], leftMax); // 总是大的值减去每个对应的小的值。！！
                res += leftMax - height[left];
                left++;
            } else {
             //from compare with preright from right to left if val is different then subtract to get res.
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}