// time: O((9!⋅K)/(9−K)!)
// space: O(k)
​	
 

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k,n,1,0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(int k, int n, int start, int sum,List<List<Integer>> res, List<Integer> list) {
        if (sum > n) return;
        if (sum == n && list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = start; i <=9; i++) {
            list.add(i);
            helper(k,n,i+1,sum+i,res,list);
            list.remove(list.size()-1);
        }
    }
}