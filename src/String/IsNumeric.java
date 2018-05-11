package String;

/**
 * Created by lqs on 2018/4/13.
 */
public class IsNumeric {
    public static boolean isNumeric(char[] str) {
        //先判断+-，以后不可以有+-
        //.后面不可以有.
        //e后面不可以.
        if (str.length == 0) {
            return true;
        }
        int i = 0;
        int integer = 0;
        int dot = 0; // 小数点位置
        int e = 0;
        if (str[i] == '+' || str[i] == '-') {
            i++;
        }
        //123.45e+6
        //-.123
        while (i < str.length) {
            if (str[i] >= '0' && str[i] <= '9') {
                i++;
                integer = i;
            } else if (str[i] == '.') {
                //如果在小数点之前就出现了小数点或者
                if (dot > 0 || e > 0) {
                    return false;
                }
                dot = i;
                i++;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (e > 0 || integer == 0) {
                    return false;
                }
                e = i;
                i++;
                if (i == str.length) {
                    return false;
                }
                if ( str[i] == '+' || str[i] == '-') {
                    i++;
                }
                if (i == str.length) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] str = new char[]{'1', '2', 'e'};
        isNumeric(str);
    }
}
