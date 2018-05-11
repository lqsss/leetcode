package dymaicProgram;

/**
 * Created by liqiushi on 2018/4/4.
 */
public class TwoKeysKeyboard {
    public static void partition(int x) {
        // int k = 2 ;
        StringBuffer sb = new StringBuffer();
        sb.append(x + "= 1");
        if (x <= 1) {
            System.out.println("无效");
        } else if (x == 2) {
            System.out.println(x + "=1*" + x);
        } else {
            for (int i = 2; i <= x; i++) {
                while (x % i == 0) {
                    sb.append("*" + i);
                    x = x / i;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        partition(27);
    }
}
