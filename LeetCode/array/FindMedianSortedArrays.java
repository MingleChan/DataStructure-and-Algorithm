package array;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        if(totalLen % 2 == 1) {
            int midIndex = totalLen / 2;
            return getKth(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLen / 2 - 1, midIndex2 = totalLen / 2;
            return (getKth(nums1, nums2, midIndex1 + 1) + getKth(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    private double getKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int i1 = 0, i2 = 0;
        while (true) {
            if(len1 == i1) {
                return nums2[i2 + k - 1];
            }
            if(len2 == i2) {
                return nums1[i1 + k - 1];
            }
            if(k == 1) {
                return Math.min(nums1[i1], nums2[i2]);
            }

            int half = k / 2;
            int newI1 = Math.min(i1 + half, len1) - 1;
            int newI2 = Math.min(i2 + half, len2) - 1;
            if(nums1[newI1] <= nums2[newI2]) {
                k -= newI1 - i1 + 1;
                i1 = newI1 + 1;
            } else {
                k -= newI2 - i2 + 1;
                i2 = newI2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        double res = f.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
