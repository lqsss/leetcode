package test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //作业数
        int m = scanner.nextInt(); //改的钱
        int x = scanner.nextInt(); //做错扣的钱
        int k = scanner.nextInt(); //做对复查的钱
        int correct = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            if (tmp == 1) {
                correct++;
            }
        }
        if (correct >= n - correct) {
            sum = n * m - correct * k - (n - correct) * x + (n - correct) * k;
        } else {
            sum = n * m - correct * k - (n - correct) * x + correct * k;
        }
        System.out.println(sum);
    }
}
