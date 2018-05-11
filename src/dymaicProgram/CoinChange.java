package dymaicProgram;

/**
 * Created by liqiushi on 2018/3/25.
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];//当前amount需要的硬币数
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5};
        coinChange(a,11);
    }
}
