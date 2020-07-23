//time:o(mn)
//space:o(mn)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
         int m = matrix.length;
       int n = matrix[0].length;
       Queue<Tuple> q = new LinkedList<>();
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (matrix[i][j] == 0) {
                   q.offer(new Tuple(i, j, 0));
               } else {
                   matrix[i][j] = Integer.MAX_VALUE; //mark unreach cell
               }
           }
       }


       while (!q.isEmpty()) {
           Tuple curr = q.poll();
           for (int[] dir : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
               int x = curr.x + dir[0];
               int y = curr.y + dir[1];
               //去满足这里matrix[x][y]成立遍历没有reach到的cell。也能排除不是最近的
               if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > curr.d) {
                   matrix[x][y] = curr.d + 1;
                   q.offer(new Tuple(x, y, matrix[x][y]));
               }
           }
       }
       return matrix;
   }


   private class Tuple {
       private int x;
       private int y;
       private int d;
       Tuple(int x, int y, int d) {
           this.x = x;
           this.y = y;
           this.d = d;
       }

    }
}