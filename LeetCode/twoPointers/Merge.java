package twoPointers;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int curPos = m + n - 1;
        --m;
        --n;
        while(m>=0 && n>=0) {
            nums1[curPos--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
        }
        System.arraycopy(nums2, 0, nums1, 0, n+1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Merge me = new Merge();
        me.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
