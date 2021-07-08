package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    ++l;
                } else if (sum > target) {
                    --r;
                } else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    ++l;
                    --r;
                    while (nums[l] == nums[l - 1]) ++l;
                    while (nums[r] == nums[r + 1]) --r;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> res = t.threeSum(nums);
        System.out.println(res);
    }
}
