package search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lqs on 2018/5/11.
 */
public class FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        int res = -1;
        if ("".equals(str)) {
            return res;
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.sort(list);
        int cnt = 0;
        int i = 0;
        for (; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                cnt++;
            } else if (list.get(i) != list.get(i + 1) && cnt == 0) {
                arr.add(str.indexOf(list.get(i)));
            } else {
                cnt = 0;
            }
        }
        if (list.get(i) != list.get(i - 1))
            arr.add(str.indexOf(list.get(i)));
        Collections.sort(arr);
        res = arr.get(0);
        return res;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar("google");
    }
}
