package math;

/**
 * Created by lqs on 2018/5/2.
 */
public class Power {
    // (n&1) == 1 奇数 0  偶数  011&001 = 1
    public double Power(double base, int exponent) {
        double res = core(base, exponent);
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }

    public double core(double base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }
        double ans = core(base, exponent / 2);
        ans = ans * ans;
        if ((exponent & 1 )== 1) { //如果是奇数
            ans = ans * base;
        }
        return ans;
    }

    public static void main(String[] args) {
        double res = new Power().Power(2, -3);
        System.out.println(res);
        int num = 3;
        System.out.println(3 & 1);
    }
}
