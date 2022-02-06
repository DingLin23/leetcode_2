// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         // time o(n^3)  space:o(n)
//         if (s.length() == 0 || s == null) return 0;
//         int ans = 1;
//         int n = s.length();
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 if (check(s,i,j)) {
//                     ans = Math.max(ans,i-j+1);
//                 }
//             }
//         }
//         return ans;
//     }
//     private boolean check (String s, int start, int end) {
//         int[] chars = new int[128];
//         for (int i = start; i < end; i++) {
//             char c = s.charAt(i);
//             chars[c]++;
//         }
//         if (chars[c] > 1) return false;
//         return true;
//     }
// }

// time:O(n) space: O(m) m size of charset
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 1;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1); // j 记录每一个发现i重复的位置。
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans,i-j+1);
        }
        return ans;
    }
}