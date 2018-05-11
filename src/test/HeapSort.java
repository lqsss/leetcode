package test;

import java.util.Arrays;

/**
 * Created by lqs on 2018/4/29.
 */
public class HeapSort {
    //堆排序入口
    public void sort(int[] array) {
        //构建最大堆
        buildMaxHeep(array);
        //进行沉淀
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0); //交换最大堆顶和堆底
            maxHeap(array, i, 0); //重新对0->i进行最大堆
        }
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
        int[] arr = new int[]{2, 25, 31, 13, 22, 19, 56, 44};
        new HeapSort().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
