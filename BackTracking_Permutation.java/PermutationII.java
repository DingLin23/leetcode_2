class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) { 
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(nums);
       helper(nums, new boolean[nums.length], new ArrayList<>(), res);
       return res;
   }


   private void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
       if (list.size() == nums.length) {
           res.add(new ArrayList<>(list));
           return;
       }
       int preNum = nums[0]-2; // 确保第一个数唯一的数所以要执行。
       for (int i = 0; i < nums.length; i++) {
           if (!visited[i] && (preNum != nums[i])) {
               preNum = nums[i];
               visited[i] = true;
               list.add(nums[i]);
               helper(nums, visited, list, res);
               list.remove(list.size()-1);
               visited[i] = false;
           }
       }
    }
}