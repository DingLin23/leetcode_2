// time:o(n)
//space:o(1)


public class FirstUniqueCharacterinaString {
    /**
     * Examples:

     s = "leetcode"
     return 0.

     s = "loveleetcode",
     return 2.

     time : O(n);
     space : O(1);

     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}