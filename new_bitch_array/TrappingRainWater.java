class Solution{
    public int trap(int[] height){
        if(height == null || height.length == 0) return 0;
        int left = 0, right = height.length-1, res = 0;
        int left_most = 0, right_most = 0;
        while(left< right){
            if(height[left] < height[right]){
                left_most = Math.max(left_most,height[left]);
                res += left_most - height[left];
                left++;
            }else{
                right_most = Math.max(right_most, height[right]);
                res += right_most - height[right];
                right--;
            }
        }
        return res;
    }
}