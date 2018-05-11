package dymaicProgram;

import java.util.Set;

/**
 * Created by liqiushi on 2018/3/26.
 */
public class wordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || s == null || dict.size() == 0 || dict == null) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1]; //dp[i]表示长度为i的字符串是否能被完美分割
        dp[0] = true; //初始值
        for (int i = 1; i <= s.length(); i++) { // 遍历得到所有长度的布尔值
            for (int j = 0; j < i; j++) { //判断是否存在一点可以完美切割当前 长度为i的字符串
                if (dp[j] && dict.contains(s.substring(j, i))) { // s的[0...j)true 且[j,i)在dict可以找到
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
