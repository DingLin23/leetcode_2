//time : O(s+t)
// space: O(s+t)

class Solution {
    public String minWindow(String s, String t) {
                 // corner case
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        
        // construct model
        int minLeft = 0;
        int minRight = 0;
        int min = s.length();
        boolean flag = false;
        
        Map<Character, Integer> map = new HashMap<>();
        int count = t.length(); // the number of characters that I need to match
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        // unfixed sliding window, 2 pointers
        int i = 0;
        int j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count--; // if still unmatched characters, then count--, >的原因是有可能tmap里面有重复的单词比如aa这样
            }
            
            // if found a susbtring
            while(count == 0 && i <= j){
                // update global min
                flag = true;
                int curLen = j + 1 - i;
                if(curLen <= min){
                    minLeft = i;
                    minRight = j;
                    min = curLen;
                }
                
                // shrink left pointer
                char leftC = s.charAt(i);
                if(map.containsKey(leftC)){
                    map.put(leftC, map.get(leftC) + 1);          
                    //map.get(leftC) >= 1 是因为如果刚好配对的话初始的map里面应该是0开始，但是有重复的话，可能value是-1；注意这时候count不加， count 还是0所以又找到一个解。这段代码就是用来找到类似aaabbc这种情况。
                    if(map.get(leftC) >= 1) count++;
                }
                i++;
            } 
            j++;
        }
        
        return flag == true ? s.substring(minLeft, minRight + 1): "";
    }
}
