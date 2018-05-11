package test1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by liqiushi on 2018/3/24.
 */
public class kquchong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = 0;
            int n = in.nextInt();
            int k = in.nextInt(); //差值
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    //dp[i][j] = arr[i] - arr[j];
                    if (Math.abs(arr[i] - arr[j]) == k) {
                        map.put(arr[i], arr[j]);
                    }
                }
            }
            HashMap<Integer, Integer> cMap = new HashMap();
            if (map.size() != 0) {
                for (Integer value : map.values()) {
                    cMap.put(value, cMap.get(value) + 1);

                }
                for (Integer value : cMap.values()) {
                    if (value > 1) {
                        count = count + value-1;
                    }
                }
            }
            System.out.println(count);
        }
    }
    
}
  /*                  if(tmp!=value && map.containsValue(value)){
                        tmp = value;
                        count++;
                    }*/