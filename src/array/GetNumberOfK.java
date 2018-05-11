package array;

/**
 * Created by lqs on 2018/5/10.
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        int m = getFirstK(array, k, 0, array.length - 1);
        int n = getLastK(array, k, 0, array.length - 1);
        if (m != -1 && n != -1) {
            return n - m + 1;
        }
        return 0;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        int mid = (start + end) >> 1;
        if (start <= end) {
            if (array[mid] < k) {
                return getFirstK(array, k, mid + 1, end);
            } else if (array[mid] > k) {
                return getFirstK(array, k, start, mid - 1);
            } else if (mid - 1 >= 0 && array[mid - 1] == k) {
                return getFirstK(array, k, start, mid - 1);
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int k, int start, int end) {
        int mid = (start + end) >> 1;
        if (start <= end) {
            if (array[mid] < k) {
                return getLastK(array, k, mid + 1, end);
            } else if (array[mid] > k) {
                return getLastK(array, k, start, mid - 1);
            } else if (mid + 1 < array.length && array[mid + 1] == k) {
                return getLastK(array, k, mid + 1, end);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GetNumberOfK test = new GetNumberOfK();
        test.GetNumberOfK(new int[]{3,3,3,3},3);
    }

}
