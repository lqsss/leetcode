package dymaicProgram;

/**
 * Created by liqiushi on 2018/4/3.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]); //找到最便宜的买入价格
            res = Math.max(res, prices[i] - min);   //update：当前卖出-最低买入和之前比较
        }
        return res;
    }
/*    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 1];//
        dp[0] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[i-1] - prices[j-1]);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }*/
}

