package greedy;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 1;
        CanPlaceFlowers c = new CanPlaceFlowers();
        boolean res = c.canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1)
                continue;
            if ((i - 1 < 0 || flowerbed[i - 1] == 0) &&
                    (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                ++cnt;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
