class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       if (maze == null || maze.length == 0 || maze[0].length == 0) return true;
       int m = maze.length;
       int n = maze[0].length;
       boolean[][] visited = new boolean[m][n];
       boolean res = bfs(maze, m, n, start, destination, visited);
       return res;
   }


   private boolean bfs(int[][] maze, int m, int n, int[] start, int[] destination, boolean[][] visited) {
       Queue<Coordinate> q = new LinkedList<>();
       q.offer(new Coordinate(start[0], start[1]));
       visited[start[0]][start[1]] = true;
       while (!q.isEmpty()) {
           Coordinate curr = q.poll();
           //出口如果找到就输出结果。
           if (curr.x == destination[0] && curr.y == destination[1]) {
               return true;
           }
           for (int[] dir : new int [][]{{0,1},{0,-1},{1,0},{-1,0}}) {
               int x = curr.x + dir[0];
               int y = curr.y + dir[1];
               //如果没有wall就一直走。看看能不能走到destination.这里不用!visited.因为要往回查
               while (0 <= x && x < m && 0 <= y && y < n && maze[x][y] == 0) {
                   x += dir[0];
                   y += dir[1];
               }
               // find stop position，and go backward;
               x -= dir[0];
               y -= dir[1];
               if (!visited[x][y]) {
                   visited[x][y] = true;
                   q.offer(new Coordinate(x, y));
               }
           }
       }
       return false;
   }


   private static class Coordinate {
       int x;
       int y;
       Coordinate(int x, int y) {
           this.x = x;
           this.y = y;
       }

    }
}