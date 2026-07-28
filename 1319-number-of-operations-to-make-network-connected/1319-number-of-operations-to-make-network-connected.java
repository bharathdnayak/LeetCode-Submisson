class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node))
            return node;

        parent.set(node, findUPar(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v)
            return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);

        int extraEdges = 0;

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findUPar(u) == ds.findUPar(v)) {
                extraEdges++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i)
                components++;
        }

        int need = components - 1;

        if (extraEdges >= need)
            return need;

        return -1;
    }
}