package dymaicProgram;

/**
 * Created by lqs on 2018/5/3.
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        int res =  dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
