package test;

import java.util.Arrays;

/**
 * Created by liqiushi on 2018/1/10.
 */
public class InsertionSort {

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 5, 8, 4, 6, 78, 26, 13, 66};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
