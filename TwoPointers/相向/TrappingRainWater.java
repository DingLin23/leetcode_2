class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length-1;
        int leftMost = 0, rightMost = 0, res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMost = Math.max(leftMost,height[left]);
                res += leftMost - height[left];
                left++;
            }else {
                rightMost = Math.max(rightMost,height[right]);
                res += rightMost - height[right];
                right--;
            }
        }
        return res;
        
    }
}