class Solution {
public int maxArea(int[] height) {
    int l = 0;
    int r = height.length-1;
    int res = 0;
    while (l < r) {
        int area;
        if (height[l] < height[r]) {
            area = height[l] * (r - l);
            l++; // 只有找到更长的柱子才能找到更大的面积
        } else {
            area = height[r] * (r - l);
            r--;
        }
        res = Math.max(res, area);
    }
    return res;
}
}
