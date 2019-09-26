class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random rdm;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        rdm = new Random();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(! map.containsKey(val)) return false;
        
        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);//[1,2x,3,4] -> [1,4,3]
            if(index != list.size()){
                list.set(index,lastVal);//把被删掉的index,填上最后一个value from list remove.
                map.put(lastVal,index); // 一样的，调换位置。

            }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rdm.nextInt(list.size())); // random 不能用map return. 所以要用list.
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */