package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 763. 划分字母区间
 */
class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        int[] last = new int[26];
        for(int i = 0; i < length; ++i) {
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < length; ++i) {
            end = Math.max(last[s.charAt(i)-'a'], end);
            if(i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = p.partitionLabels(s);
        System.out.println(Arrays.toString(res.toArray(new Integer[0])));
    }
}
