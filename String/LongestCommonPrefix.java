public class LongestCommonPrefix {
    /**
     * 14. Longest Common Prefix
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     *
     * case : "edwardshi", "edward", "edwar", "edwardshidd"
     * 
     * 
     * time : O(mn);
     * space : O(1);
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) { //or use startsWith() method
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
