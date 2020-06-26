//time:O(nlgk)
//space:O(n+k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
       for (int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }
       // 建立最小堆
       Queue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
       for (int num : map.keySet()) {
           pq.offer(num);
           if (pq.size() > k) {
               pq.poll();
           }
       }
       // 此时最小堆有k个元素
       int[] res = new int[k];
       for (int i = 0; i < k; i++) {
           res[i] = pq.poll();
       }
       return res;

    }
}