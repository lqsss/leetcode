package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lqs on 2018/4/28.
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        Integer[] value = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            value[i] = input[i];
        }
        Comparator cmp = new sortNum();
        Arrays.sort(value, cmp);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = input.length - 1; i >= 0 && k > 0; i--) {
            res.add(input[i]);
            k--;
        }
        return res;
    }

    public ArrayList<Integer> test(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k) {
            return res;
        }
        buildMaxHeep(input);
        for (int i = input.length - 1; i >= 0; i--) {
            swap(input, i, 0);
            maxHeap(input, i, 0);
        }

        for (int i = 0; i < input.length && i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void buildMaxHeep(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //从中间往前开始遍历，结构稳定
        int half = (array.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);  //递归：比较交换
        }
    }


    private void maxHeap(int[] array, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxNode = i;

        if (left < length && array[left] > array[i]) {
            maxNode = left;
        }
        if (right < length && array[right] > array[maxNode]) {
            maxNode = right;
        }
        if (maxNode != i) {
            //说明左右子节点比当前i节点大
            //swap
            swap(array, i, maxNode);
            maxHeap(array, length, maxNode); //继续递归maxNode，跟它的下面比较
        }
    }

    private void swap(int[] array, int i, int maxNode) {
        int tmp = array[i];
        array[i] = array[maxNode];
        array[maxNode] = tmp;
    }

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal();
        threadLocal.set(1);
        threadLocal.get();

        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        new GetLeastNumbers_Solution().test(arr, 4);
    }
}

class sortNum implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1.compareTo(o2) < 0) {
            return -1;
        } else if (o1.compareTo(o2) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length - 1 && k > 0; i++) {
            res.add(input[i]);
            k--;
        }
        return res;
    }

}


