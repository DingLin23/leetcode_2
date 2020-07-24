class Solution {
    //在大西洋的boolean true 在太平洋的boolean true的话就说明有答案。
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
       List<List<Integer>> res = new ArrayList<>();
       if (matrix.length == 0 || matrix[0].length == 0) {
           return res;
       }
       int m = matrix.length;
       int n = matrix[0].length;
       boolean[][] pvisited = new boolean[m][n];
       boolean[][] avisited = new boolean[m][n];
       Queue<Coordinate> pq = new LinkedList<>();
       Queue<Coordinate> aq = new LinkedList<>();
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (i == 0 || j == 0) { // 最上，和最左的两排肯定是能流pacific的
                   pq.offer(new Coordinate(i, j));
                   pvisited[i][j] = true;
               }
               if (i == m-1 || j == n-1) {
                   aq.offer(new Coordinate(i, j)); // 最右和最下的肯定能流atlantic的
                   avisited[i][j] = true;
               }
           }
       }
       bfs(matrix, m, n, pq, pvisited);
       bfs(matrix, m, n, aq, avisited);

        // 找两个都是true的。
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (pvisited[i][j] && avisited[i][j]) {
                   res.add(Arrays.asList(i, j));
               }
           }
       }
       return res;
   }


   private void bfs(int[][] matrix, int m, int n, Queue<Coordinate> q, boolean[][] visited) {
       while (!q.isEmpty()) {
           Coordinate curr = q.poll();
           for (int[] dir : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
               int x = curr.x + dir[0];
               int y = curr.y + dir[1];
               if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && matrix[x][y] >= matrix[curr.x][curr.y]) { //matrix[x][y] >= matrix[curr.x][curr.y] 新的要大于等于旧的才能flow过去
                   visited[x][y] = true;
                   q.offer(new Coordinate(x, y));
               }
           }
       }
   }


   private class Coordinate {
       private int x;
       private int y;
       Coordinate(int x, int y) {
           this.x = x;
           this.y = y;
       }

    }
}