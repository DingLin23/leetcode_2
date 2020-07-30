class Solution {
    public int numDistinctIslands(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       boolean[][] visited = new boolean[m][n];
        //排除相同的形状的图
       Set<String> res = new HashSet<>();
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (!visited[i][j] && grid[i][j] == 1) {
                   String shape = bfs(grid, m, n, i, j, visited);
                   res.add(shape);
               }
           }
       }
       return res.size();
   }


   private String bfs(int[][] grid, int m, int n, int i, int j, boolean[][] visited) {
       int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
       Queue<Coordinate> q = new LinkedList<>();
       q.offer(new Coordinate(i, j));
       visited[i][j] = true;
       StringBuilder sb = new StringBuilder();


       while (!q.isEmpty()) {
           Coordinate curr = q.poll();
           for (int k = 0; k < dirs.length; k++) {
               int x = curr.x + dirs[k][0];
               int y = curr.y + dirs[k][1];
               if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && grid[x][y] == 1) {            // 存方向的index来判断是否是一样的图型。不能用int[] dir : dirs 这种写法，sb.append(dir)是错误的，存的是一维数组，会有duplicate的数出现。
                   sb.append(k);
                   visited[x][y] = true;
                   q.offer(new Coordinate(x, y));
               }
           }
           sb.append(",");
       }
       return sb.toString();
   }


   private class Coordinate {
       int x;
       int y;
       Coordinate(int x, int y) {
           this.x = x;
           this.y = y;
       }
   }
}