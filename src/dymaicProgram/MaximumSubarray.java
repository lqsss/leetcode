package dymaicProgram;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 2018/3/8.
 */
public class MaximumSubarray {
    //dp[i] = max(dp[i-1]+nums[i],nums[i]) 以nums[i]为尾节点最大子数组之和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(null,1);
        map.put(null,2);
    }
}
