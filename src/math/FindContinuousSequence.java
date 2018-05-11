package math;

import java.util.ArrayList;

/**
 * Created by lqs on 2018/4/17.
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum == 1) {
            return res;
        }
        int[][] dp = new int[1000][1000];
        //init
        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = i;
            // dp[i][i + 1] = 2 * i + 1;
            for (int j = i + 1; j < dp[0].length; j++) {
                if (dp[i][j - 1] < sum) {
                    dp[i][j] = dp[i][j - 1] + j;
                }
                if (dp[i][j] == sum) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        arr.add(k);
                    }
                    res.add(arr);
                    break;
                } else if (dp[i][j] > sum) {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     * @param sum
     * @return ArrayList<ArrayList<Integer>>
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum == 1) {
            return res;
        }

        int small = 1;
        int big = 2;
        int curSum = small + big;
        while (small < (sum + 1) / 2) {
            if (curSum < sum) {
                big++;
                curSum += big;
            } else if (curSum > sum) {
                curSum -= small;
                small++;
            }
            if (curSum == sum) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int k = small; k <= big; k++) {
                    arr.add(k);
                }
                res.add(arr);
                big++;
                curSum += big;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(3);
    }
}
