//time:o(lgn)
//space:o(1d)

class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;
        while (left < right) {
            long mid = (left+right+1) >>> 1;
            if (mid*mid > x) {
                right = mid-1;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }
}