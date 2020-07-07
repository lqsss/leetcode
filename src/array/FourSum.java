package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqs
 * @version 1.0
 * @date 2020/7/5 9:39 下午
 */
public class FourSum {
    public static List<List<Integer>> fourSum1(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;


            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
                if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

                for (int p = j + 1; p < nums.length - 1; p++) {
                    if (p > j + 1 && nums[p] == nums[p - 1]) {
                        continue;
                    }
                    int q = nums.length - 1;
                    while (p < q && nums[i] + nums[j] + nums[p] + nums[q] >= target) {
                        if (nums[i] + nums[j] + nums[p] + nums[q] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[p]);
                            list.add(nums[q]);
                            res.add(list);
                            break;
                        }
                        q--;
                    }

                    if (q == p) {
                        break;
                    }
                }
            }

        }
        return res;
    }


    /**
     * 双指针简写
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;


            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
                if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

                int left = j + 1;
                int right = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(arr, 0);
        System.out.println(lists);
    }
}
