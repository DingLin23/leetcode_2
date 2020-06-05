//time:o(n^2)
//space:o(n)
public class Solution {
    public boolean canPartition(int[] nums) {
	int sum = 0;
	for (int n : nums) sum += n;
	if ((sum % 2) == 1) return false;

	sum /= 2;
	boolean[] dp = new boolean[sum + 1];
	dp[0] = true;
	for (int n : nums) {
		for (int i = sum; i >= n; i--) {
			dp[i] = dp[i] || dp[i-n];
		}
	}

	return dp[sum];
}
}