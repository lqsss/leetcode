package dymaicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 2018/3/27.
 */
public class Triangle {
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        //自底向上
        //dp[i]：到索引i的最小路径 dp[i] = arr[i] + min(dp[i+1] ,dp[i])
        for (int i = dp.length - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        //dp[i][j]：在（i,j）的最小路径
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        //在dp最后一行比较一个最小路径
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List row1 = new ArrayList<>();
        row1.add(1);
        List row2 = new ArrayList<>();
        row2.add(2);
        row2.add(3);
        triangle.add(row1);
        triangle.add(row2);
        int res = minimumTotal(triangle);
        //minimumTotal(new int[]{});
    }
/*    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
             int sum;
             sum = getResult(triangle, 0, 0);
             return sum;
           }

       

    public int getResult(ArrayList<ArrayList<Integer>> triangle, int l, int k) {
             int sum = triangle.get(l).get(k);
             if (l < triangle.size() - 1)
                sum = sum + Math.min(getResult(triangle, l + 1, k), getResult(triangle, l + 1, k + 1));
             return sum;
           }*/
}
