package tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        /**
         * 左右后：root节点的右子树的最左节点就是大于root的最小
         * 后序遍历中第一个大于root值的节点就是分割左右子树的index
         */
        for (i = 0; i < sequence.length; i++) {
            if (sequence[i] > rootVal) {
                break;
            }
        }
        if(i == sequence.length){//没找到，就是前面的都是左子树
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
       // boolean res = VerifySquenceOfBST.VerifySquenceOfBST(test);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
    }
}
