//time:O(nlgn)
//space: O(1)
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2) return -1;
        int left = 0, right = A.length-1, res = -1;
        Arrays.sort(A);
        while(left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                res = Math.max(res,sum);
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}