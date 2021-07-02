package greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < prev)
                ++cnt;
            else
                prev = intervals[i][1];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1,2}, {2,3}, {3,4}, {1,3} };
        EraseOverlapIntervals e = new EraseOverlapIntervals();
        int res = e.eraseOverlapIntervals(intervals);
        System.out.println(res);
    }
}
