package dymaicProgram;

/**
 * Created by liqiushi on 2018/3/28.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //dp[i][j]:表示s.substr(0,i)匹配t.substr(0,j)符合的值
        for (int i = 0; i <= s.length(); i++) {
            //当t为空时，s删除全部字符即可匹配，值为1
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j]; //等于前面一个字符的匹配值
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //如果当前ij字符匹配(当前s和t的最后一个字符串)
                    //可选可不选
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println(num >> 4);
    }
}
