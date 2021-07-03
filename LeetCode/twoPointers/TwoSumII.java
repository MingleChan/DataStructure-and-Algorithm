package twoPointers;

import java.util.Arrays;

/**
 * 167. 两数之和 II
 */
class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum < target)
                ++start;
            else if(sum > target)
                --end;
            else
                break;
        }
        return new int[]{start+1, end+1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSumII t = new TwoSumII();
        int[] res = t.twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }
}
