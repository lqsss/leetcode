package String;

import java.util.Arrays;

/**
 * Created by lqs on 2018/4/14.
 */
public class ReplaceSpace {

    public static String replaceSpace1(StringBuffer str) {
        if (str.length() == 0) {
            return str.toString();
        }
        if (str.charAt(str.length() - 1) == ' ') {
            str.replace(str.length() - 1, str.length(), "%20");
        }
        String orinal = str.toString();
        String[] orinalArr = orinal.split(" ");
        String res = "";
        for (int i = 0; i < orinalArr.length; i++) {
            if (i == orinalArr.length - 1)
                res += orinalArr[i];
            else
                res += orinalArr[i] + "%20";
        }
        return res;
    }

    public static String replaceSpace(StringBuffer str) {
        //从左往右替换space，字符串得移动
        //从右往左移动，先扩大长度，
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int oldLength = str.length();
        int newLength = oldLength + spaceNum * 2;
        str.setLength(newLength);
        int j = oldLength - 1;// oldIndex
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(j) == ' ') {
                str.setCharAt(i--, '0');
                str.setCharAt(i--, '2');
                str.setCharAt(i, '%');
                j--;
            } else {
                str.setCharAt(i, str.charAt(j--));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String res = replaceSpace(new StringBuffer("hello world"));
        System.out.println(res);
    }
}
