//time: o(t)
//space:o(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s == null || s.length() == 0) return true;
        int index = 0;
        
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }
}