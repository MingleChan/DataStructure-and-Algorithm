package greedy;

/**
 * 122. 买卖股票的最佳时机 II
 */
class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                maxProfit += (prices[i] - prices[i-1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        MaxProfit m = new MaxProfit();
        int res = m.maxProfit(p);
        System.out.println(res);
    }
}
