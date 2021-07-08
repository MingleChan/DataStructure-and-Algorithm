package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> vToIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int val = target - nums[i];
            if(vToIndexMap.containsKey(val))
                return new int[]{vToIndexMap.get(val), i};
            vToIndexMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum t = new TwoSum();
        int[] res = t.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
