package array;

/**
 * Created by lqs on 2018/5/1.
 */
public class ReOrderArray {
    //前部分奇数，后部分偶数
    public static void reOrderArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int target = array[i];
                int j = i;
                for (; j >= 1 && array[j - 1] % 2 == 0; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = target;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(arr);
    }
}
