package array;

import java.util.ArrayList;

/**
 * Created by lqs on 2018/5/2.
 */
public class PrintMatrix {
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        core(matrix);
        return res;
    }

    private void core(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = col - 1;
        int bottom = row - 1;
        while (top <= bottom && left <= right) {
            //->
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            //右下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            //<-
            //如果只有一行了，之前从左到右已经遍历过了
            for (int i = right - 1; i >= left && top < bottom; i--) {
                res.add(matrix[bottom][i]);
            }
            //上
            //如果只有一列了，之前从上到下已经遍历过了
            for (int i = bottom - 1; i > top && right > left; i--) {
                res.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }









    /*public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }
        for (int i = row; i >= 1; i = i - 2) {
            core(matrix, i);
        }
        return res;
    }

    public void core(int[][] matrix, int n) {
        int row = matrix[0].length;
        int start = (row - n) / 2; // (start,start) n n-1 n-1 n-2
        //->
        for (int i = start; i < start + n; i++) {
            res.add(matrix[start][i]);
            System.out.println(matrix[start][i]);
        }
        //右下(1,3)(3,3)
        //n= 2 start = 1 i = 2 ;
        for (int i = start + 1; i <= n + start - 1; i++) {
            res.add(matrix[i][start + n - 1]);
            System.out.println(matrix[i][start + n - 1]);
        }
        //<-
        // i = 1
        for (int i = n + start - 2; i >= start; i--) {
            res.add(matrix[n + start - 1][i]);
            System.out.println(matrix[n + start - 1][i]);
        }
        //上
        for (int i = n + start - 2; i >= start + 1; i--) {
            res.add(matrix[i][start]);
            System.out.println(matrix[i][start]);
        }
    }*/
}
