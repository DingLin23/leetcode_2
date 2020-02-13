//time: o(n)
//space:o(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; i++) {
            //peek first
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                //if condition True, then index in res = stack.pop();
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}