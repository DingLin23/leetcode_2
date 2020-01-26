//time: O(mn)
//space:O(1)
class Solution {
    // dead -> live 5
    // live -> dead 4
    // count(board,i,j)
    // update(); 5 ->1, 4 ->0;
    final static int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 0){
                    int lives = count(board,i,j);
                    if(lives == 3){
                        board[i][j] = 5;
                    }
                }
                if(board[i][j] == 1){
                    int lives = count(board,i,j);
                    if(lives <2 || lives >3){
                        board[i][j] = 4;
                    }
                }
            }
        }
        update(board);
    }
    private void update(int[][] board){
        if(board == null || board.length == 0) return;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 5){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 4){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int count(int[][]  board, int rows,int cols){
        int res = 0;
        for(int[] dir : dirs){
            int newRow = rows + dir[0];
            int newCol = cols + dir[1];
            if(newRow >= 0 && newRow < board.length && newCol >=0 && newCol < board[0].length && (board[newRow][newCol] == 1 || board[newRow][newCol] == 4)){
                // 这里的board[newrow][newcol] == 4 因为在原先它是活的还没变换之前。
                res++;
            }
        }
        return res;
    }
}