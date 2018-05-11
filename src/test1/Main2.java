package test1;

import java.util.Scanner;

/**
 * Created by liqiushi on 2018/3/24.
 */
public class Main2 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("a");
        String m = s.toString();
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if(length % 2 == 0){
            
        }
    }
    
    public static String add1(String m , StringBuilder s){
        m =  s.toString();
        s.append(s) ;
        return m;
    }

    public static void add2(String m , StringBuilder s){
        s.append(m) ;
    }
}
