//time:O(lgn)
//space:O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if( matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

       int m = matrix.length;
       int n = matrix[0].length;
       int lo = 0;
       int hi = m*n-1;
       while (lo+1<hi) {
           int mid = lo+(hi-lo)/2;
           if (matrix[mid/n][mid%n] <= target) {
               lo = mid;
           } else {
               hi = mid;
           }
       }
       return matrix[lo/n][lo%n] == target || matrix[hi/n][hi%n] == target;


        
    }
}