package dymaicProgram;

/**
 * Created by liqiushi on 2018/4/1.
 */
public class DecodeWays {
    public  int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1]; //dp[i]表示长度为i能编码的种数
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first > 0 && first <= 9) {
                //看成一个单数
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                //看成一个小于26两位数
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}
