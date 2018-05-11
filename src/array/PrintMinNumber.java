package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by lqs on 2018/5/4.
 */
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> res = new ArrayList<>();
        for (Integer item : numbers) {
            res.add(String.valueOf(item));
        }
        /**
         * 比较规则：拼接后的大小
         */
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        String result = "";
        for (String str : res) {
            result += str;
        }
        return result;
    }
}
