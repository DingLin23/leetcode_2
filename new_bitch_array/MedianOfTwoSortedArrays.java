class Solution {
    //time: o(log(m+n))
    //space: o(1)
    //思路其实就是merge sort pluds binary search smaller size array in order to have log(m+n)的run time。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length, lenB = nums2.length;
        if(lenA > lenB){
            return findMedianSortedArrays(nums2,nums1);
        }
        if(lenA == 0){
            // 写法去找中间值。 要用/ 这个。
            return ((double)nums2[(lenB-1)/2] + (double)nums2[lenB/2])/2;
        }
        
        int len = lenA + lenB;
        int a_startK =0, a_endK = lenA;
        int cutA = 0,cutB =0;
        while(a_startK <= a_endK){
            cutA = (a_endK + a_startK)/2;
            cutB = (len+1)/2 - cutA;
            double l1 = (cutA == 0)? Integer.MIN_VALUE:nums1[cutA-1];
            double l2 = (cutB == 0)? Integer.MIN_VALUE:nums2[cutB-1];
            double r1 = (cutA == lenA)? Integer.MAX_VALUE:nums1[cutA];
            double r2 = (cutB == lenB)? Integer.MAX_VALUE:nums2[cutB];
            if(l1 > r2){
                a_endK = cutA-1;
            }
            else if(l2 > r1){
                a_startK = cutA+1;
            }
            else{
                if(len % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return Math.max(l1,l2);
                }
            }
        }
        return -1;
    }
}