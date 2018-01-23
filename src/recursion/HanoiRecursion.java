package recursion;

/**
 * Created by liqiushi on 2018/1/15.
 */
public class HanoiRecursion {
    /**
     * H(n) = H(n-1) + 1 + H(n-1)
     *
     * @param n 层数
     * @param x 起始
     * @param y 目的
     * @param z 中转
     */
    public void hannoi(int n, char x, char y, char z) {
        if (n == 0) {

        } else {
            hannoi(n - 1, x, z, y);
            System.out.println(x + "->" + y);
            hannoi(n - 1, z, y, x);
        }
    }

    public static void main(String[] args) {
        HanoiRecursion hanoi = new HanoiRecursion();
        hanoi.hannoi(3, 'a', 'b', 'c');
    }
}
