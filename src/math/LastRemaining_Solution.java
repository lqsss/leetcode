package math;

import java.util.*;

/**
 * Created by lqs on 2018/5/10.
 */
public class LastRemaining_Solution {
    //n为人数(0~n-1)编号，m为轮询数字
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0){
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //6 m=3 begin=0,cur=2   index: 0 2
        //5 m=3 begin=3,cur=5
        //4 m=3 begin=1,cur=3
        //3 m=3 begin=4,(4,0,1)cur=1  （4+2）%3
        //2 m=3 begin=4,cur=4   4+2/2 -1
        //1 0
        //
        int begin = 0;//
        int cur = (begin + m - 1) % list.size();//6
        while (list.size() > 1) {
            /*begin + m - 1 > list.size()-1;*/
            int delete = list.indexOf(new Integer(cur));
            list.remove(delete);
            int next = (delete + m - 1) % list.size();
            cur = list.get(next);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int res = LastRemaining_Solution(6, 7);
        System.out.println(res);
    }
}
