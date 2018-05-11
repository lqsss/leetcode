package recursion;

/**
 * Created by liqiushi on 2018/3/25.
 */
public class Fibonacci {
    public int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
