//time: o(n^2)
//space: o(n)

class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) return 0;
        
        //init
        int [] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        
        int ans = n;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && find(i,father) != find(j,father)) {
                    union(i,j,father);
                    ans--;
                }
            }
        }
        return ans;
        
    }
    
    private int find(int p, int[]father) {
        if (father[p] == p) return p;
        father[p] = find(father[p], father);
        return father[p];
    }
    
    private void union (int p1, int p2, int[] father) {
        int f1 = find(p1,father),  f2 = find(p2,father);
        if (f1 != f2) {
            father[f1] = f2;
        }
    }
}