package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 */
class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if(p1[0] != p2[0]) {
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        ReconstructQueue r = new ReconstructQueue();
        int[][] res = r.reconstructQueue(people);
        System.out.println(Arrays.deepToString(res));
    }
}
