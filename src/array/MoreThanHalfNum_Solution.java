package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by lqs on 2018/4/26.
 */
public class MoreThanHalfNum_Solution {
/*    HashMap<Integer, Integer> map = new HashMap<>();

    public void Insert(int num) {
        if (map.get(num) != null) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int target = array.length / 2 + 1;
        for (int item : array) {
            Insert(item);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer res = iterator.next();
            if (map.get(res) >= target) {
                return res;
            }
        }
        return 0;
    }*/

    /**
     * O(n)优化
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int res = array[0];
        int times = 1;
        int target = array.length / 2 + 1;// 超过大多数
        //根据数组的特性，超过数组长度一半的数字，必定比其他数字出现次数之和都还要大
        //遍历数组，如果与当前res相等，则出现次数+1，出现其他数字则-1
        //如果减到0了，则交换当前array[i]的值给res，继续遍历
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                res = array[i];
                times = 1;
            } else if (array[i] == res) {
                times++;
            } else {
                times--;
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                count++;
            }
            if (count >= target) {
                return res;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(array);
    }
}
