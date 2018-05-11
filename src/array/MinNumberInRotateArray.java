package array;

/**
 * Created by lqs on 2018/4/18.
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (array[mid] < array[high]) {
                high = mid;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high = high - 1;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        minNumberInRotateArray(new int[]{3, 4, 5, 1, 2});
    }
}
