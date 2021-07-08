package array;
/**
 * 11. 盛水最多的容器
 */
class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while(l < r) {
            int w = r - l;
            int h = height[r] > height[l] ? height[l++] : height[r--];
            int area = w * h;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea m = new MaxArea();
        int res = m.maxArea(height);
        System.out.println(res);
    }
}