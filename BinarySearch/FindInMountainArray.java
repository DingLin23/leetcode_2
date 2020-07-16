/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 //time: o(lgn)
 //space: o(1)
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length()-1;
        int peak = findPeak(target,mountainArr,left,right);
        int res = findRes(target,mountainArr,left,peak,true);
        if (res != -1) {
            return res;
        }else {
            return findRes(target, mountainArr, peak+1, right,false);
        }
    }
    
    private int findPeak(int target,MountainArray A,int left, int right) {
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (A.get(mid) < A.get(mid+1)) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return A.get(left) > A.get(right)? left : right;
    }
    private int findRes(int target,MountainArray A, int left, int right,boolean ascend) {
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (A.get(mid) == target) return mid; 
            else {
                if (ascend) {
                    if (A.get(mid) < target) left = mid; // 因为山峰朝两边扩散变低。
                    else right = mid;
                }
                else {
                    if (A.get(mid) < target) right = mid;// 因为山峰朝两边扩散变低。
                    else left = mid;
                }
            }
        }
        if (A.get(left) == target) return left;
        if (A.get(right) == target) return right;
        return -1;
    }
}