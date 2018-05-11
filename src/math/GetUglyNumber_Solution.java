package math;

/**
 * 丑数
 * Created by lqs on 2018/5/7.
 */
public class GetUglyNumber_Solution {
    public static int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] uglyNum = new int[index]; //存储index个丑数
        uglyNum[0] = 1; //第一个丑数 1
        int cur = 1; //遍历下标
        //对数组里存在的每个丑数都进行*2、*3、*5，找到比当前最大丑数最小的一个数，效率低
        //如果记录一个对于*2的更新下标，要求:这个下标以前的*2都小于当前最大丑数，这个下标以后都大于最大丑数
        int uglyNum2 = 0; // 2、3、5
        int uglyNum3 = 0;
        int uglyNum5 = 0;
        while (cur < index) {
            int min = Math.min(uglyNum[uglyNum2] * 2, Math.min(uglyNum[uglyNum3] * 3, uglyNum[uglyNum5] * 5));
            uglyNum[cur] = min;
            while (uglyNum[uglyNum2] * 2 <= min) {
                uglyNum2++;
            }
            while (uglyNum[uglyNum3] * 3 <= min) {
                uglyNum3++;
            }
            while (uglyNum[uglyNum5] * 5 <= min) {
                uglyNum5++;
            }
            cur++;

        }
        return uglyNum[index - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution(6);
    }
}
