/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 //time :o(lgn)
 //spcae: o(1)

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        
        while (reader.get(right) < target) { //取当前最大的值，如果小于target, expend size by 2.
            left = right;
            right <<= 1;
        }
        
        
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (target > reader.get(mid)) {
                left = mid;
            }
            else if (target < reader.get(mid)) {
                right = mid;
            }else {
                return mid;
            }
        }
        
        if (reader.get(left) == target) return left;
        else if (reader.get(right) == target) return right;
        return -1;
    }
}