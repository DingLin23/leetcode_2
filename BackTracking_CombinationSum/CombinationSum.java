//time: o((n+k)!)
//space: o(m) size in the res

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if(sum+A[i] > target) break;
           list.add(A[i]);
           helper(A, target, i, sum + A[i], list, res);
           list.remove(list.size() - 1);
       }
    }
}