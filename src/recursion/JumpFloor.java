package recursion;

/**
 * Created by liqiushi on 2018/3/25.
 */
public class JumpFloor {
    /*    public int JumpFloor(int target) {
            if(target == 0  ){
                return 0;
            }
            if(target == 1  ){
                return 1;
            }
            if(target == 2 ){
                return 2;
            }
            return JumpFloor(target-1)+ JumpFloor(target-2);
        }*/
    public static int JumpFloor(int target) {
        if(target == 0 ){
            return 0;
        }
        if(target == 1  ){
            return 1;
        }
        if(target == 2 ){
            return 2;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        JumpFloor(1);
    }
}
