package String;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lqs on 2018/4/25.
 */
public class Permutation {
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        permutationProcess(str.toCharArray(), 0, str.length() - 1);
        Collections.sort(res);
        return res;
    }

    /**
     * 全排列
     * @param chars
     * @param start
     * @param end
     */
    private void permutationProcess(char[] chars, int start, int end) {
        //递归边界条件:只剩下最后一个元素
        if (start == end) {
            res.add(String.valueOf(chars));
            return;
        }
        for (int i = start; i <= end; i++) { //固定第一个（start）位置，就会有n种可能
            if (i == start || chars[start] != chars[i]) { //去掉重复的可能情况
                swap(chars, i, start);  //交换当前下标到start位置
                permutationProcess(chars, start + 1, end); //全排列剩下字符串
                swap(chars, i, start); //再次交换，将他们还原，为下次交换首位置做准备
            }
        }
    }

    private void swap(char[] chars, int start, int end) {
        char tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
    }

    public static void main(String[] args) {
        new Permutation().Permutation("abc");
    }

}
