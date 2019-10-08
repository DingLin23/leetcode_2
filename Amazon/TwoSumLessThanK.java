//runtime:O(nlgn)
//space: O(1)
//two points
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
       int max = -1, i = 0, j = A.length -1;
        while(i<j){
            if(A[i]+A[j]<K){
                max = Math.max(max,A[i]+A[j]);
                i++;
            }else{
                
                j--;
            }
        }
        return max;
    }
}