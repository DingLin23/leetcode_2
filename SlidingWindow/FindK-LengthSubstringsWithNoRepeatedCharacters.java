//time: o(n)
//space: o(n)
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
     if (S == null || S.length() == 0 || K > S.length()) return 0;
     int ans = 0;
     Set<Character> set = new HashSet<>();
     int i = 0;
     
     for (int j = 0; j < S.length(); j++) {
         while (set.contains(S.charAt(j))) {
             set.remove(S.charAt(i++)); // 只要找到重复的就删除前一个。从当前的开始
         }
         set.add(S.charAt(j));
         
         if (j - i + 1 == K) { // 边界 ，这里i的位置是每次排查完某个重复的位置。如果没有重复j就一直跑知道到k的位置。所以j-i， +1 的原因是index start from 0;
             ans++;
             set.remove(S.charAt(i++)); // 找到了也要删除，sliding the window;
         }
     }
     return ans;
 }
}
