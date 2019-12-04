//time:O(nlg(n))
// space:O(n)
//yes
class Solution {    
    public int connectSticks(int[] sticks) {
        Queue<Integer> pq = new PriorityQueue<Integer>(); //自动排序升序。
        for(int i: sticks) pq.add(i);
        int ans = 0;
        while(pq.size() > 1){
            int t = pq.poll() + pq.poll();   // sum the two smallest 
            ans +=t;  // count the cost
            pq.offer(t); //一个queue里面可以放一个temp的指针去临时存储
        }
        return ans;
    
    }
    
}