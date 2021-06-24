package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        int cnt = 1;
        Arrays.sort(points, (a, b)->a[1] > b[1] ? 1 : -1);
        int curArrowPos = points[0][1];
        for(int i = 1; i < points.length; ++i) {
            if(points[i][0] > curArrowPos) {
                curArrowPos = points[i][1];
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] a = {{10,16},{2,8},{1,6},{7,12}};
        FindMinArrowShots f = new FindMinArrowShots();
        int minArrowShots = f.findMinArrowShots(a);
        System.out.println(minArrowShots);
    }
}
