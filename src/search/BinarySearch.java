package search;

/**
 * Created by liqiushi on 2018/3/11.
 */
public class BinarySearch {
    public static int noRecursion(int[] arr, int key, int low, int high) {
        while (low < high) {
            int mid = (low + high) >>> 1;
            int sortNum = arr[mid];
            if (key > sortNum) {
                low = mid + 1;
            } else if (key < sortNum) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursion(int[] arr, int key, int low, int high) {
        int mid = (low + high) >>> 1;
        int sortNum = arr[mid];
        int res = -1;
        if (key > sortNum) {
            res = recursion(arr, key, mid + 1, high);
        } else if (key < sortNum) {
            res = recursion(arr, key, low, mid - 1);
        } else {
            return mid;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5};
        System.out.println(recursion(arr, 1, 0, arr.length - 1));
        System.out.println(noRecursion(arr, 1, 0, arr.length - 1));
    }
}
