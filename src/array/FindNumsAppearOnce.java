package array;

/**
 * Created by liqiushi on 2018/3/10.
 */
public class FindNumsAppearOnce {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        divide(array, 0, array.length - 1);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length && array[i] == array[i + 1]) {
                i++;
            }else{
                count ++ ;
                if(count == 1 ){
                    num1[0] = array[i];
                }else if(count == 2){
                    num2[0] = array[i];
                }
            }
        }
        }

    public static int qsort(int[] array, int left, int right) {
        int sortNum = array[left];
        while (left < right) {

            while (left < right && array[right] >= sortNum) {
                right--;
            }
            if (left < right) {
                array[left++] = array[right];
            }

            while (left < right && array[left] <= sortNum) {
                left++;
            }

            if (left < right) {
                array[right--] = array[left];
            }


        }
        array[left] = sortNum;
        return left;
    }

    public static void divide(int[] array, int left, int right) {
        if (left < right) {
            int mid = qsort(array, left, right);
            divide(array, 0, mid - 1);
            divide(array, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
/*        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num1[0]);
    }
}
