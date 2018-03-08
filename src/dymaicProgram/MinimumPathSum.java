package dymaicProgram;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Created by liqiushi on 2018/3/8.
 */
public class MinimumPathSum {
    //dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i == 0){
                    if(j == 0){
                        dp[i][j] = grid[i][j];
                    }else{
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
