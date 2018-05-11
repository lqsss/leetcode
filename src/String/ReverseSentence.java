package String;

/**
 * Created by lqs on 2018/4/23.
 */
public class ReverseSentence {
    public  String ReverseSentence(String str) {
        if(str.length() == 0){
            return "";
        }
        if(str.trim().equals("")){
            return " ";
        }
        String res1 = reverse(new StringBuffer(str));
        String[] strArr = res1.split(" ");
        String res = "";
        for (String item : strArr) {
            res += reverse(new StringBuffer(item))+" ";
        }
        return res.substring(0, res.length() - 1);
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
        String s = new String(" ");
        new ReverseSentence().ReverseSentence(s);
    }
}
