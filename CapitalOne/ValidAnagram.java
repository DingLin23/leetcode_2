//time: o(nlgn)
//space: o(n)

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
    
        Arrays.sort(sChar);
        Arrays.sort(tChar);
    
        return Arrays.equals(sChar, tChar);   
    }
}

//time: o(n)
//space: o(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}