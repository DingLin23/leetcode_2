//time: o(2^n)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(candidates);
       helper(candidates, target, 0, 0, new ArrayList<>(), res);
       return res;
   }


   private void helper(int[] A, int target, int start, int sum, List<Integer> list, List<List<Integer>> res) {
       if (sum > target) {
           return;
       }
       if (sum == target) {
           res.add(new ArrayList<>(list));
           return;
       }
       for (int i = start; i < A.length; i++) {
           if(i > start && A[i] == A[i-1]) continue; /** skip duplicates */
           list.add(A[i]);
           //you can only use an element in the candidates array once. In the next dfs, you have to start at i + 1 position.
           helper(A, target, i+1, sum + A[i], list, res);
           list.remove(list.size()-1);

       }
    }
}