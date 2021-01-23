package cn.superming.DataStructure;

public class UnionFindSet {
    private int[] parent;
    private int[] rank;   // 基于高度进行合并
    private int count;

    public UnionFindSet(int n) {
        this.count = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int size(){
        return count;
    }

    public int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new RuntimeException("over set size.");
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  // 路经压缩
            p = parent[p];
        }
        return p;
    }

    public boolean isConnect(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pTag = find(p);
        int qTag = find(q);

        if (pTag == qTag)
            return;
        if (rank[pTag] < rank[qTag]){
            parent[pTag] = qTag;
        } else if (rank[pTag] > rank[qTag]){
            parent[qTag] = pTag;
        } else {
            parent[qTag] = pTag;
            rank[pTag]++;
        }
    }
}
