package String;

/**
 * Created by lqs on 2018/4/23.
 */
public class LeftRotateString {
    public String LeftRotateString1(String str, int n) {
        if (n > str.length()) {
            return "";
        }
        String last = str.substring(0, n);
        String front = str.substring(n, str.length());
        return front + last;
    }

    public String LeftRotateString(String str, int n) {
        if (n > str.length()) {
            return "";
        }
        String last = str.substring(0, n);
        String front = str.substring(n, str.length());
        last = reverse(new StringBuffer(last));
        front = reverse(new StringBuffer(front));
        String res = reverse(new StringBuffer(last + front));
        return res;
    }

    private String reverse(StringBuffer item) {
        int low = 0;
        int high = item.length() - 1;
        while (low < high) {
            char cTmp = item.charAt(low);
            item.setCharAt(low, item.charAt(high));
            item.setCharAt(high, cTmp);
            low++;
            high--;
        }
        return item.toString();
    }

    public static void main(String[] args) {
        new LeftRotateString().LeftRotateString("abcdefg",2);
    }
}
