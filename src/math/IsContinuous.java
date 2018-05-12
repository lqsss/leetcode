package math;

/**
 * Created by lqs on 2018/5/12.
 */
public class IsContinuous {
    int[] d = new int[14];
    int min = 14;
    int max = -1;

    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        d[0] = -5;
        for (int i = 0; i < numbers.length; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) {
                return false;
            }
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }
}
