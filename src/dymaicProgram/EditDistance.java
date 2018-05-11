package dymaicProgram;

/**
 * Created by liqiushi on 2018/4/3.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //init
        //str2 == ""
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        //str1 == "" 
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //修改、删除、增加
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a= "aabbcc";
        System.out.println(a.substring(1));
                
    }
}
