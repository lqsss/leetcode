package array;

import java.util.ArrayList;

/**
 * Created by lqs on 2018/5/3.
 */
public class PrintMinNumber1 {
    public ArrayList<String> res = new ArrayList<>();

    public String PrintMinNumber(int[] numbers) {
        int min = Integer.MAX_VALUE;

        sort(numbers, 0, numbers.length - 1);
        for (String str : res) {
            min = Math.min(min, Integer.parseInt(str));
        }
        return min + "";
    }

    //全排列
    public void sort(int[] numbers, int start, int end) {
        if (start == end) {
            String str = "";
            for (int i = 0; i < numbers.length; i++) {
                str += numbers[i];
            }
            res.add(str);
            return;
        }
        for (int i = start; i <= end; i++) {
            if (i == start || numbers[i] != numbers[start]) {
                swap(numbers, i, start);
                sort(numbers, start + 1, end);
                swap(numbers, i, start);
            }
        }
    }

    private void swap(int[] numbers, int i, int start) {
        int tmp = numbers[i];
        numbers[i] = numbers[start];
        numbers[start] = tmp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3334, 3, 3333332};
        new PrintMinNumber().PrintMinNumber(num);
    }
}
