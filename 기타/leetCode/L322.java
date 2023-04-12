package leetCode;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/

public class L322 {
	public int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}

		for (int i = 0; i < amount + 1; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j])
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}

		if (dp[amount] > amount) {
			dp[amount] = -1;
		}

		return dp[amount];

	}
}
