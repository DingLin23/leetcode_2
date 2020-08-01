class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,Set<Integer>> graph = intialGraph(n, edges);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) { //从零这个点出发到找到所有的连线的点。其实就是uf。
            if (!set.contains(i)) {
                count++;
                bfs(i,edges,graph,set);
            }
        }
        return count;
   }
    
   //共用一个set。
    private void bfs(int i, int[][] edges,Map<Integer,Set<Integer>> graph,Set<Integer>set) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        set.add(i);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph.get(node)) {
                if (!set.contains(neighbor)) {
                    q.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
    }
    
    private Map<Integer,Set<Integer>> intialGraph(int n, int[][]edges) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i,new HashSet<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}