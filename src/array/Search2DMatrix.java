package array;

/**
 * Created by liqiushi on 2018/3/19.
 */
public class Search2DMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length;
        int column = 0;
        if (row > 0) {
            column = matrix[0].length;
        }

        for (int r = 0, c = column - 1; (r <= row - 1) && (c >= 0); ) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 分治 中心点
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = 0;
        if (row > 0) {
            column = matrix[0].length;
        }
        return find(matrix, 0, 0, row - 1, column - 1, target);
    }

    private boolean find(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        int midx = (x1 + x2) >> 1;
        int midy = (y1 + y2) >> 1;
        if (target < matrix[midx][midy]) {
            return find(matrix, x1, y1, midx - 1, y2, target) || find(matrix, midx , y1, x2, midy - 1, target);
        } else if (target > matrix[midx][midy]) {
            return find(matrix, x1, midy + 1, x2, y2, target) || find(matrix, midx + 1, y1, x2, midy, target);
        } else {
            return true;
        }
    }
}
