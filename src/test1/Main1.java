package test1;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < num; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int z1 = scanner.nextInt();
            if (x1 >= 0 && x1 <=x && y1 >= 0 && y1 <= y && z1 >= 0 && z1 <= z) {
                result++;
            }
        }
        System.out.println(result);
    }
}
