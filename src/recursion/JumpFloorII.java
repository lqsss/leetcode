package recursion;

/**
 * f(n) = f(n-1) + f(n-2)+ ... + f(n-(n-1)) + f(n-n)
 * f(n-1) = f(n-2)+ f(n-3) +...+f(n-(n-1)) + f(n-n)
 * f(n) = 2*f(n-1)
 * Created by liqiushi on 2018/3/25.
 */
public class JumpFloorII {
    public int JumpFloorII1(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII1(target - 1);
    }

    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        }
        int dp[] = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[target];
    }
}
