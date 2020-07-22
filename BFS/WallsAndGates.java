//DFS
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    doDfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void doDfs(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] == -1 || rooms[i][j] < distance) {
            // do not run dfs on out of boundry nodes, obstacle or another gate
            //rooms[i][j] < distance track 还没被遍历的cell，还有就是如果找最接近gate的cell的话就update。
            return;
        }
        rooms[i][j] = distance;
        for (int[] dir: new int[][]{{0,1},{1,0},{-1,0},{0,-1}}) {
            doDfs(rooms, i + dir[0], j + dir[1], distance+1);
        }
    }
}