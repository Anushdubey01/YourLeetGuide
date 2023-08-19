class UnionFind {
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i)
            parent[i] = i;
    }

    public void unionByRank(int u, int v) {
        final int rootU = find(u);
        final int rootV = find(v);
        if (rootU == rootV)
            return;
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootU] = rootV;
            ++rank[rootV];
        }
    }

    public int find(int u) {
        return parent[u] == u ? u : (parent[u] = find(parent[u]));
    }

    private int[] parent;
    private int[] rank;
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int numNodes, int[][] inputEdges) {
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        int numEdges = inputEdges.length;

        // Record the index information, so edges[i] := (u, v, weight, index).
        int[][] edges = new int[numEdges][4];
        for (int i = 0; i < numEdges; ++i)
            edges[i] = new int[]{inputEdges[i][0], inputEdges[i][1], inputEdges[i][2], i};

        // Sort by weight.
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        final int mstWeight = getMSTWeight(numNodes, edges, new int[]{}, -1);

        for (int[] edge : edges) {
            final int index = edge[3];
            // Deleting `edgeToDelete` makes the MST weight increase or can't form a MST.
            if (getMSTWeight(numNodes, edges, new int[]{}, index) > mstWeight)
                criticalEdges.add(index);
            // If an edge can be in any MST, we can always add `edgeToAdd` to the edge set.
            else if (getMSTWeight(numNodes, edges, edge, -1) == mstWeight)
                pseudoCriticalEdges.add(index);
        }

        return new ArrayList<>(Arrays.asList(criticalEdges, pseudoCriticalEdges));
    }

    private int getMSTWeight(int numNodes, int[][] edges, int[] edgeToAdd, int edgeToDeleteIndex) {
        int mstWeight = 0;
        UnionFind uf = new UnionFind(numNodes);

        if (edgeToAdd.length == 4) {
            uf.unionByRank(edgeToAdd[0], edgeToAdd[1]);
            mstWeight += edgeToAdd[2];
        }

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            final int weight = edge[2];
            final int index = edge[3];
            if (index == edgeToDeleteIndex)
                continue;
            if (uf.find(u) == uf.find(v))
                continue;
            uf.unionByRank(u, v);
            mstWeight += weight;
        }

        final int root = uf.find(0);
        for (int i = 0; i < numNodes; ++i)
            if (uf.find(i) != root)
                return Integer.MAX_VALUE;

        return mstWeight;
    }
}