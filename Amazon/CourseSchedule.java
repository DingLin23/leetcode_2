//BFS Topological sort
//time:o(E+V)
//space:o(n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses]; // 记录每门课的先修课
        
        //为每门课开一个list 存放它的先修课
        for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<>();
        }
        
        //把先修课放到每一个课程的list里 & 统计入度数量
        for(int i = 0; i < prerequisites.length; i++){
            //先修课 ->当前课
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            //当前入度++
            indegree[prerequisites[i][0]]++;
            }
        
            //bfs
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){//没有先修课
                queue.offer(i);
            }
        }
        
        int count = 0; //统计一共上过的课程数量。
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            int n = edges[course].size(); //有n门课以当前的course作为先修课，course -》n个其他课程          
            for (int i = 0; i < n; i++){
                int pointer = (int)edges[course].get(i);
                indegree[pointer]--;
                
                //判断pointer课是否入度为0
                if(indegree[pointer] == 0){
                    queue.add(pointer);
                }
            }
        }
        return count == numCourses;
    }

}
                                           

// 0->1
// 0 -> 1  1 <- 0 
//有向+无环