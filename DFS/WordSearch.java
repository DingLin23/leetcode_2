// Time Complexity: O(N⋅3^L)where N is the number of cells in the board and 
//L is the length of the word to be matched
// Space: O(L)

class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)){
            return false;
        }
        
        board[i][j] = '#';
        for (int dir[] : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
            int x = i+dir[0];
            int y = j+dir[1];
            if (search(board,word,x,y,index+1)){
                return true;
            }
        }
        //还原，可能是一个有效路径的一个点。
        board[i][j] = word.charAt(index);
        return false;
    }
}