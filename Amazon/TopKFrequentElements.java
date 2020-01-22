//time:O(n)
//space:O(n)

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //getOrDefault的作用就是如果遇见同一个输出一样的value,不同的话加上。
            // 给同样出现的num 赋值上出现的次数 as val
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        //keyset 拿到所有key
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            //保证了most freq的数字被排到最后。
            bucket[freq].add(num);
        }

        //最后把，bucket sort 的值加到res arraylist 里
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}