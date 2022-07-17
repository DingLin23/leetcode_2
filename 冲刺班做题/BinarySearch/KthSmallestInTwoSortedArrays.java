public class kthSmallestInTwoSortedArrays {
    public int kth(int[] A, int[] B, int k) {
        if (k < 0 || k > A.length + B.length) return -1;
        int kSmallest = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int index = 0; index < k; index++) {
            if (i < A.length && j < b.length) {
                kSmallest = A[i] < B[i] ? A[i++] : B[j++];
            }else if (i < A.length ) { // 相等的情况 move i or j 都可以， 但是要排查是否有一个越界
                kSamllest = A[i++];
            }else {
                kSamllest = B[j++];
            }
        }
        return kSmallest;
    }
}
