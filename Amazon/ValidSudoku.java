//time: O(1)
// space:O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //每一行，每一列，没个box都要查
        for(int i=0;i<9;i++) {
            //用来count frequency of number
            int[] rowValues = new int[10];
            int[] columnValues = new int[10];
            int[] boxValues = new int[10];
            for(int j=0;j<9;j++) {
                char row = board[i][j];
                if (row != '.' && ++rowValues[row-'0']>1)
                    return false;
                
                char column = board[j][i];
                if (column != '.' && ++columnValues[column-'0']>1)
                    return false;
                
                char box = board[(i/3)*3+j/3][(i%3)*3+j%3];
                if (box != '.' && ++boxValues[box-'0']>1)
                    return false;
            }
        }
        return true;
    }
}