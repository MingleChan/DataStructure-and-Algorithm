package array;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            ++fast;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        RemoveDuplicates r = new RemoveDuplicates();
        int res = r.removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, res)));
    }
}
