//time: o(lgn)
//space: o(1)

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;//corner case, cant divide by zero.
        int left = 0, right = x;
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (mid == x/mid) return mid;
            else if (mid < x/mid) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return (right == x/right)? right : left; //因为答案要很接近x所以要先输出right。
    }
}