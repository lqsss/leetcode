package dymaicProgram;

/**
 * Created by liqiushi on 2018/4/2.
 */
public class MinPathSum1 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int j = 0; j < col; j++) {
            if (j == 0) {
                dp[0][j] = grid[0][0];
            } else {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
        }

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
