//time: o(n)
//space: o(1)

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i <= haystack.length()-needle.length(); i++){
            // i as index,切同等长度的与needle做对比看看一样不。
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}