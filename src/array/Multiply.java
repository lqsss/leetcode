package array;

/**
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * Created by liqiushi on 2018/3/24.
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A == null) {
            return null;
        }
        int[] B = new int[A.length];
        if (B.length == 0) {
            return B;
        }
        B[0] = 1;
        //先计算了 B[i] = A[0]*A[1]*A[2]*...*A[i-1]
        for (int i = 1; i < A.length; i++) {
            B[i] = A[i - 1] * B[i - 1];
        }
        //后部分:
        int tmp = 1;
/*        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i+1];
            B[i] = tmp * B[i];
        }*/
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] = tmp * B[i];
            tmp *= A[i];
        }
        
        return B;
    }
}
