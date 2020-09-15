package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {

        if (k == 0) {
            return 1;
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        int count = 0;

        while (!q.isEmpty()) {
            int[] qNode = q.poll();
            int oldX = qNode[0];
            int oldY = qNode[1];

            if (!access(oldX, oldY, k)) continue;
            count++;


            for (int i = 0; i < direction.length; i++) {
                int newX = oldX + direction[i][0];
                int newY = oldY + direction[i][1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && visited[newX][newY] == 0) {
                    visited[newX][newY] = 1;
                    q.add(new int[]{newX, newY});
                }
            }
        }

        return count;
    }

    private boolean access(int x, int y, int k) {
        int res = 0;
        while (x != 0 || y != 0) {
            if (x != 0) {
                res += x % 10;
                x /= 10;
            }

            if (y != 0) {
                res += y % 10;
                y /= 10;
            }

            if (res > k) {
                return false;
            }
        }

        return true;
    }
}
