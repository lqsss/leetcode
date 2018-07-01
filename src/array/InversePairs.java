package array;

/**
 * 归并排序的思想
 * 归并的两数组是有序的，在合并比较的过程中求出逆序对的数量
 * 左+右+合并的
 * Created by lqs on 2018/5/12.
 */
public class InversePairs {
    public static int InversePairs(int[] array) {
        int res = mergeSort(array, 0, array.length - 1);
        return res;
    }

    private static int mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        int leftRes = mergeSort(array, start, mid) % 1000000007;
        int rightRes = mergeSort(array, mid + 1, end) % 1000000007;
        int midRes = mergeCore(array, start, mid, end) % 1000000007;
        return (leftRes + rightRes + midRes) % 1000000007;
    }

    private static int mergeCore(int[] array, int start, int mid, int end) {
        int count = 0;
        int[] tmp = new int[end - start + 1];
        int i = mid;
        int j = end;
        int k = tmp.length - 1;
        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                tmp[k--] = array[i--];
                //4 5 2 3
                count += j - mid; //mid~j之间的数都小于array[i]
                if (count > 1000000007) {
                    count = count % 1000000007;
                }
            } else {
                tmp[k--] = array[j--];
            }
        }
        for (; i >= start; i--) {
            tmp[k--] = array[i];
        }
        for (; j >= mid + 1; j--) {
            tmp[k--] = array[j];
        }
        for (int l = 0; l < tmp.length; l++) {
            array[start++] = tmp[l];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{7,5,6,4};
        InversePairs(arr);
    }
}
