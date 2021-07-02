package array;
/**
 * 11. 盛水最多的容器
 */
class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        int h;
        int temp;
        int w;
        while(l < r){
            w = r - l;
            h = height[l] > height[r] ? height[r--] : height[l++];
            temp = w * h;
            max = Math.max(temp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea m = new MaxArea();
        int res = m.maxArea(height);
        System.out.println(res);
    }
}