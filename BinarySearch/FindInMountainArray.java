/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
          int peak = findPeakIndex(mountainArr);
       int res = findTarget(mountainArr, target, 0, peak, true);
       if (res != -1) {
           return res;
       } else {
           return findTarget(mountainArr, target, peak+1, mountainArr.length()-1, false);
       }
   }

   private int findPeakIndex(MountainArray A) {
       int lo = 0;
       int hi = A.length()-1;
       while (lo+1<hi) {
           int mid = lo+(hi-lo)/2;
           if (A.get(mid) < A.get(mid+1)) {
               lo = mid;
           } else {
               hi = mid;
           }
       }

       return A.get(lo) > A.get(hi) ? lo : hi;
   }

   private int findTarget(MountainArray A, int target, int lo, int hi, boolean ascend) {
       while (lo+1<hi) {
           int mid = lo+(hi-lo)/2;
           if (A.get(mid) == target) {
               return mid;
           } else {
               if (ascend) {
                   if (A.get(mid) < target) {
                       lo = mid;
                   } else {
                       hi = mid;
                   }
               } else {
                   if (A.get(mid) < target) {
                       hi = mid;
                   } else {
                       lo = mid;
                   }
               }
           }
       }
       if (A.get(lo) == target) {
           return lo;
       } else if (A.get(hi) == target) {
           return hi;
       } else {
           return -1;
       }
    }
}