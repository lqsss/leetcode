package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 2017/9/20.
 */
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0 ; i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0 ;i<nums.length;i++){
            int otherElement = target - nums[i];
            if(map.containsKey(otherElement) && map.get(otherElement) != i){
                return new int[]{i,map.get(otherElement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        ReverseInteger res = new ReverseInteger();
        System.out.println(res.reverse(2356));
    }


}
