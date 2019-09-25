//BFS Topological sort
//time:o(E+V)
//space:o(n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; 
        List[] edges = new ArrayList[numCourses];// 记录每个课程的precoureses

        //为每门课开一个list存放它的先修课
        for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<Integer>();
        }

        //把先修课放到每一个课程的list里 & 统计入度数量。
        for(int i = 0; i < prerequisites.length; i++){
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
    }
}

// 0->1
// 0 -> 1  1 <- 0 
//有向+无环