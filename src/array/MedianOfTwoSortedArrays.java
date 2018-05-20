package array;

/**
 * Created by liqiushi on 2018/3/19.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;

        if (length % 2 == 0) {
            return (getMid(nums1, nums2, length >> 1) + getMid(nums1, nums2, (length >> 1) + 1)) * 0.5;
        } else {
            return getMid(nums1, nums2, length + 1 >> 1);
            //0 1 2 3 4 5 6
        }
    }

    private static int getMid(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        for (; (i < m) && (j < n); ) {
            k--;
            if (nums1[i] < nums2[j]) {
                if (k == 0) {
                    return nums1[i];
                }
                i++;
            } else if (k == 0) {
                return nums2[j];
            } else {
                j++;
            }
        }
        return i >= m ? nums2[j + k - 1] : nums1[i + k - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{2, 3};
        findMedianSortedArrays(arr1, arr2);
    }
}
