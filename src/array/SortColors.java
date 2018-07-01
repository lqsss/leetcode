package array;

/**
 * Created by liqiushi on 2018/3/21.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int cur = 0;
        int begin = 0;
        int end = nums.length - 1;
        while (cur <= end) {
            if (nums[cur] == 0) {
                swap(nums, cur, begin);
                begin++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, end);
                end--;
            }
        }
    }

    private void swap(int[] nums, int cur, int begin) {
        int tmp = nums[cur];
        nums[cur] = nums[begin];
        nums[begin] = tmp;
    }
}
