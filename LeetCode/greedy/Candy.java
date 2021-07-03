package greedy;

/**
 * 135. 分发糖果
 */
class Candy {
    public int candy(int[] ratings) {
        int[] candyArr = new int[ratings.length];
        candyArr[0] = 1;
        for(int i = 1; i < ratings.length; ++i) {
            if(ratings[i] > ratings[i-1])
                candyArr[i] = candyArr[i-1] + 1;
            else
                candyArr[i] = 1;
        }
        for(int i = ratings.length - 2; i >= 0; --i) {
            if(ratings[i] > ratings[i+1] && candyArr[i] <= candyArr[i+1])
                candyArr[i] = candyArr[i+1] + 1;
        }
        int cnt = 0;
        for(int c : candyArr)
            cnt += c;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 2};
        Candy c = new Candy();
        int candy = c.candy(a);
        System.out.println(candy);
    }
}
