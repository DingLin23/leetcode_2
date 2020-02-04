// time:o(n);
//space:o(1);

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) { // checking " " will return 0,//只有找到有common prefix的时候跳出，去对比下一个string
                
                //如果没找到每一次就是切一个char再做对比。
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}