public class MonsoonUmbrellas {
    public static int getUmbreallas(int requirement, List<Integer> sizes) {
        if (sizes == null || sizes.size() == 0) return -1;
        int dp[] = new int[requirement+1]; 
        dp[0] = 0;
        for (int i = 1; i <= requirement; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < sizes.size(); j++) {
                if (i >= sizes.get(j) && dp[i-sizes.get(j)] != -1)  {
                    min = Math.min(min,dp[i-sizes.get(j)]+1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[requirement];
    }
}