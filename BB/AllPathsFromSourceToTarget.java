//time:O(2^N * N^2)
//Space: O(2^n * n)

class Solution {
    //题意根据每一个subARRAY的值的数来确定落在index的位置。作为指向
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        helper(graph, tmp, 0, res);
        return res;
    }
    private void helper(int[][] graph,List<Integer> tmp, int cur, List<List<Integer>> res){
        //base case
        if(cur == graph.length-1){
            res.add(new ArrayList(tmp));// java passing by address u have to new, otherwise not gonna print same value;
        }
        for (int next : graph[cur]){
            tmp.add(next);
            helper(graph, tmp, next,res);
            tmp.remove(tmp.size()-1); // final index is closing one. will be always empty.
        }
    }
}