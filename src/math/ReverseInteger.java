package math;

/*
Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class ReverseInteger {
    public int reverse(int x){
        int flag = 1;
        double s = 0;
        if(x == 0) return 0;

        if(x <0 ){
            flag = -1;
            x = x*(-1);
        }

        while(x>0){
            s = s*10 + x%10;
            x = x/10;
        }
        System.out.println(s);
        s = s*flag;
        return new Double(s).intValue();
    }

}
