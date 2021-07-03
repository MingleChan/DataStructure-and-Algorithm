package greedy;

/**
 * 665. 非递减数列
 */
class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; ++i) {
            int x = nums[i], y = nums[i+1];
            if(x > y){
                ++cnt;
                if(cnt > 1)
                    return false;
                if(i > 0 && y < nums[i-1])
                    nums[i+1] = x;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        CheckPossibility c = new CheckPossibility();
        boolean b = c.checkPossibility(nums);
        System.out.println(b);
    }
}
