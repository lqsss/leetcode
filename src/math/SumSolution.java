package math;

/**
 * Created by lqs on 2018/5/7.
 */
public class SumSolution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum + Sum_Solution(n--)) > 0);
        return sum;
    }
}
