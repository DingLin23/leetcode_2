class Solution {
    // 还可以做是否有环的题
    public boolean validTree(int n, int[][] edges) {
        if (edges.length+1 != n) return false;
        
        Map<Integer,Set<Integer>> graph = initialGraph(n, edges);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(0);
        set.add(0);
        int visited = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;
            for (int neighbor : graph.get(node)) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return (visited == n);
    }
    
    private Map<Integer,Set<Integer>> initialGraph(int n, int[][] edges) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}