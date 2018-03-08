package array;

/**
 * Created by liqiushi on 2018/3/3.
 */
public class Duplicate {
    private static int j = 0;
    
/*    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashSet<Integer> set = new HashSet<>();
        if (length == 0) {
            return false;
        }
        for (Integer item : numbers) {
            if (set.contains(item)) {
                duplication[0] = item;
                //duplication[i++] = item;
                return true;
            }
            set.add(item);
        }
        return false;
    }*/

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean result = false;
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[j++] = numbers[i];
                    result = true;
                    break;
                }
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        int[] duplicate = new int[arr.length];
        Duplicate.duplicate(arr,7,duplicate);
        for (Integer item:duplicate) {
            System.out.println(item);
        }
        //System.out.println(duplicate.toString());
    }
}
