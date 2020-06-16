//time:o(n)
//space: o(n)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0 ) return res;
        
        int rowBegin = 0, rowEnd = matrix.length-1;
        int colBegin = 0, colEnd = matrix[0].length-1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            
        //iteration the first row
            for(int i  = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
             rowBegin++;
            
        //iteration the last col
            for(int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd --;
            
            
        // check if already last row or col
            if(rowBegin <= rowEnd){
                for(int i = colEnd; i >= colBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
                 rowEnd --;
            
            if(colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
            }
             colBegin ++;
        
    }
        return res;
    }
}