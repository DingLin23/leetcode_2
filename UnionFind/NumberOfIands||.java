class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
       boolean[][] exist = new boolean[m][n];
       UF uf = new UF(m*n);
       for (int[] p : positions) {
           if (!exist[p[0]][p[1]]) {
               exist[p[0]][p[1]] = true;
               uf.cnt++; // a new land added
               for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                   int x = p[0] + dir[0];
                   int y = p[1] + dir[1];
                   //exist[x][y] 去测试之前已经存在的island，如果还被遍历到，count--；连通在一起了。
                   if (0 <= x && x < m && 0 <= y && y < n && exist[x][y]) {
                       uf.union(p[0] * n + p[1], x * n + y); // 2d to 1d 
                   }
               }
           }
           res.add(uf.cnt);
       }
       return res;
   }


   private static class UF {
       int n;
       int[] parent;
       int cnt;
       UF(int n) {
           this.n = n;
           cnt = 0;
           parent = new int[n];
           for (int i = 0; i < n; i++) {
               parent[i] = i;
           }
       }


       int find(int p) {
           while (p != parent[p]) {
               parent[p] = parent[parent[p]];
               p = parent[p];
           }
           return p;
       }


       void union(int p, int q) {
           int rp = find(p);
           int rq = find(q);
           if (rp == rq) return;
           parent[rq] = rp;
           cnt--; //连通了，island #就减少1
       }
   }
}