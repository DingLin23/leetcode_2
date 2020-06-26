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


    //algo: first we put num in nums into hashmap which will has num as key, freq as val. 
    //then we creat a linked list names bucket add freq as index and num as val.
    //so the most freq will be put the last index as go on. we call out

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] res = new int[k];
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            // this is why we start i = bucket.length - 1;
            bucket[freq].add(key);
        }
        
        for (int i = bucket.length - 1; i >= 0 && k > 0; i-- ) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    res[--k] = n;
                }
            }
        }
        return res;
        }
    }