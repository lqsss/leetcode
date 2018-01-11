package test;

import java.util.Arrays;

/**
 * Created by liqiushi on 2017/12/26.
 */
public class MergeSort {
    public static void sort(int arr[], int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //0 1 
            sort(arr, low, mid);//0 0、
            sort(arr, mid + 1, high);//1 1
            merge(arr,low,mid,high);
        }
    }

    /**
     * 有序地合并两个数组
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int arr[], int low, int mid, int high) {
        int[] sortArr = new int[high-low+1];
        int i = 0;
        int j = low;
        int k = mid+1;
        while (j <= mid && k  <= high) {
            if (arr[j] <= arr[k]) {
                sortArr[i++] = arr[j++];
            } else {
                sortArr[i++] = arr[k++];
            }
        }
        while (j > mid && k  <= high) {
            sortArr[i++] = arr[k++];
        }
        while (k > high && j <= mid) {
            sortArr[i++] = arr[j++];
        }
        for (int l = 0; l < sortArr.length; l++) {
            arr[low+l] = sortArr[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 4, 6, 78, 26, 13, 66};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //arr,low,high
        //sort(arr,0,arr.length-1);
    }
}
