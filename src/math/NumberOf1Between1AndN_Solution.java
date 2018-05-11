package math;

/**
 * 出现1的次数
 * 12 拆开1 2来看，各位每0~9一轮之后，十位进1，则需要一轮（十位数0->1）;
 * 而最终各位是2>1，则在第二轮里，0~9运动到了2，还要加上一个1 res: 01、11 两次
 * 例如:30143
 * 个位上:3014 3 拆开成两部分看，个位上出现1的次数 = (3014+1)*1 (3>1)
 * 十位上:301 43，十位上出现1的次数 = (301+1)*10 (4>1)
 * 301 00~301 43 十位上出现1的次数为10次(10~19)
 * 百位上:30 143，百位上出现1的次数 = (30+0)*100 +43 + 1(1=1)
 * 30 000 ~ 30 143，就只有30 100~30 143 一共43+1次
 * 千位上:3 0143，千位上出现1的次数 = (3+0)*1000 (0<1)
 * https://blog.csdn.net/yi_afly/article/details/52012593
 * Created by lqs on 2018/5/8.
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        int current;
        int base = 1;
        int remain = 0;
        while (n > 0) {
            current = n % 10;
            n /= 10;
            if (current > 1) {
                res += (n + 1) * base;
            } else if (current == 1) {
                res += n * base + remain + 1;
            } else {
                res += n * base;
            }
            remain += current * base; //3 43 143
            base *= 10;
        }
        return res;
    }
}
