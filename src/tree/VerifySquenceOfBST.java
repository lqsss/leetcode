package tree;

import java.util.Arrays;

/**
 * Created by liqiushi on 2018/3/7.
 */
public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if(sequence.length <= 1 ){
            return true;
        }
        int rootVal = sequence[sequence.length - 1];
        int i;
        for (i = 0; i < sequence.length; i++) {
            if (sequence[i] > rootVal) {
                break;
            }
        }
        if(i == sequence.length){
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, sequence.length-1));
        }
        int[] leftArr = Arrays.copyOfRange(sequence, 0, i);
        int[] rightArr = Arrays.copyOfRange(sequence, i , sequence.length-1);
        for (int j = 0; j < leftArr.length; j++) {
            if (rootVal < leftArr[j]) {
                return false;
            }
        }
        for (int j = 0; j < rightArr.length; j++) {
            if (rootVal > rightArr[j]) {
                return false;
            }
        }
        if(leftArr.length == 0){
            return VerifySquenceOfBST(rightArr);
        }
        return VerifySquenceOfBST(leftArr) && VerifySquenceOfBST(rightArr);
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,4,3,2,1};
        boolean res = VerifySquenceOfBST.VerifySquenceOfBST(test);
    }
}
