package dymaicProgram;

/**
 * Created by liqiushi on 2018/3/26.
 */
public class Candy {
    public static int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }

        return res;
    }

/*    public static void main(String[] args) {
        candy(new int[]{2,2});
    }*/
}