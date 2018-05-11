package dymaicProgram;

/**
 * Created by liqiushi on 2018/3/24.
 */
public class NumTrees {
    //C(n,m)
    public static int c(int n, int m) {
        int up = 1;
        for (int i = 1; i <= m; i++) {
            up *= n--;
            up /= i;
        }
        return up;
    }

    public static void main(String[] args) {
        System.out.println(c(5,2));
    }
}
