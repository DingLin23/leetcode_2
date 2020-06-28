//time:o(n!)
//space: o(n)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       helper(nums, new boolean[nums.length], new ArrayList<>(), res);
       return res;
   }


   private void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
       if (list.size() == nums.length) {
           res.add(new ArrayList<>(list));
           return;
       }
       for (int i = 0; i < nums.length; i++) {
           if (!visited[i]) {
               list.add(nums[i]);
               visited[i] = true;
               helper(nums, visited, list, res);
               visited[i] = false;
               list.remove(list.size() - 1);
       }
   }

    }
}