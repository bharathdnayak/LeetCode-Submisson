class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int ans = -1;
        int minCount = Integer.MAX_VALUE;

        for (int src = 0; src < n; src++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq =
                    new PriorityQueue<>((a, b) -> a[0] - b[0]);

            dist[src] = 0;
            pq.offer(new int[]{0, src});

            while (!pq.isEmpty()) {

                int[] cur = pq.poll();

                int d = cur[0];
                int node = cur[1];

                if (d > dist[node])
                    continue;

                for (int[] nei : adj.get(node)) {

                    int next = nei[0];
                    int wt = nei[1];

                    if (d + wt < dist[next]) {
                        dist[next] = d + wt;
                        pq.offer(new int[]{dist[next], next});
                    }
                }
            }
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (i != src && dist[i] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                ans = src;
            }
        }

        return ans;
    }
}