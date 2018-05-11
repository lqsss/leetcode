package math;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by lqs on 2018/4/17.
 */
public class FindNumbersWithSum {
    /**
     * HashMap<value,i></>
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        int mulMin = 0;
        for (int i = 0; i < array.length; i++) {
            int target = sum - array[i];
            if (map.containsKey(target) && i < map.get(target)) {
                if (res.size() == 0) {
                    res.add(array[i]);
                    res.add(target);
                    mulMin = array[i] * target;
                } else {
                    if (array[i] * target < mulMin) {
                        res.set(0, array[i]);
                        res.set(1, target);
                    }
                }
            }
        }
        return res;
    }

    /**
     * two pointer
     * @param array
     * @param sum
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = array.length - 1;
        int mulMin = 0;
        while (start < end) {
            int curSum = array[start] + array[end];
            if (curSum < sum) {
                start++;
            } else if (curSum > sum) {
                end--;
            }else if (curSum == sum) {
                if (res.size() == 0) {
                    res.add(array[start]);
                    res.add(array[end]);
                    mulMin = array[start] * array[end];
                } else {
                    if (array[start] * array[end] < mulMin) {
                        res.set(0, array[start]);
                        res.set(1, array[end]);
                    }
                }
                start++;
                end--;
            }
        }
        return res;
    }
}
