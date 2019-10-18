//time:O(n^2)
//space:O(n^2)

class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
        String res = "";
        boolean [][] dp = new boolean[n][n];
        for(int i = n; i>= 0; i--){
            for(int j = i; j <n; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && (res == null || j-i+1>res.length())){
                    res= s.substring(i, j+1);
                }
            }
        }
        return res;
        
        
    }
}