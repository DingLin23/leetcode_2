//time:o(n)
//space:o(n)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        //corner case
        if(s == null || t == null) return true;
        
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char si = s.charAt(i);
            char ti = t.charAt(i);
            
            if(map.containsKey(si)){
                if(map.get(si) != ti) return false;
            }else{
                if(map.containsValue(ti)) return false;
                else map.put(si,ti);
            }
        }
        return true;
    }



// time : O(n) space : O(1)
public boolean isIsomorphic2(String s, String t) {
    int[] sChars = new int[256];
    int[] tChars = new int[256];

    for (int i = 0; i < s.length(); i++) {
        if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
            return false;
        } else {
            sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
        }
    }
    return true;
}
}
