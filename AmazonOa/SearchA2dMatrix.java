//runtime: o(n*m)
//space: o(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // corner case matrix null or length = 0
        // binary search
        // make matrix into a array， match back to 2D matrix
        if( matrix == null || matrix.length == 0) return false;
        
        int row = matrix.length; 
        int col = matrix[0].length;
        int start = 0, end = row*col-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[mid/col][mid%col] == target) return true;
            if(matrix[mid/col][mid%col] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}