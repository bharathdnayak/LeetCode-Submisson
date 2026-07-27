class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int node = cur.node;
            int wt = cur.wt;

            if (vis[node])
                continue;

            vis[node] = true;
            sum += wt;

            for (int next = 0; next < n; next++) {

                if (!vis[next]) {

                    int dist =
                            Math.abs(points[node][0] - points[next][0]) +
                            Math.abs(points[node][1] - points[next][1]);

                    pq.offer(new Pair(next, dist));
                }
            }
        }

        return sum;
    }
}