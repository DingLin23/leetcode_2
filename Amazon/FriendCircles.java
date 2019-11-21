//time:o(n^2)
//space:o (n)

class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int [M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++){
            if(visited[i] == 0){
                dfs(M, visited,i);
                count ++; //u know yourself always gonna +1 after dfs
            }
        }
        return count;
    }
    private void dfs(int [][] M, int[] visited, int i){ // int i where the student u are try to iteration for
        for(int j = 0; j< M.length;j++){
            if(M[i][j] == 1 && visited[j] == 0){ // visited[j] == 0排除同一个人占两个坑或者更多       
                visited[j] = 1;
                dfs(M,visited,j);
                
            }
        }
        
    }
}


//    tim  kim   wow
// tim 1    1     0

// kim 1    1     0

// wow 0    0     1