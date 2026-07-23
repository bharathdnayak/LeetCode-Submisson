class Solution {

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new long[]{v, wt});
            adj.get(v).add(new long[]{u, wt});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int MOD = (int)1e9 + 7;

        long[] ways = new long[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long d = cur[0];
            int node = (int)cur[1];

            if (d > dist[node]) continue;

            for (long[] nei : adj.get(node)) {

                int next = (int)nei[0];
                long wt = nei[1];
                if (d + wt < dist[next]) {

                    dist[next] = d + wt;
                    ways[next] = ways[node];

                    pq.offer(new long[]{dist[next], next});
                }
                else if (d + wt == dist[next]) {

                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}