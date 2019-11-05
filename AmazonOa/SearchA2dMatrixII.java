//time: o(n+m)
//space: o(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i  = 0;
        int j = col -1;
        while(i < row && j >= 0){ // col from right to left, row up to down
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target){
                j--;
            }
            else if(matrix[i][j] < target){
                i++;
            }
        }
       return false;
    }
}