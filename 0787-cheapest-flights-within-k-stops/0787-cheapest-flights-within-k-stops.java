class Pair {
    int stops;
    int node;
    int cost;

    Pair(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(0, flight[1], flight[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int stops = cur.stops;
            int node = cur.node;
            int cost = cur.cost;

            if (stops > k)
                continue;

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                int edgeCost = it.cost;

                if (cost + edgeCost < dist[adjNode]) {

                    dist[adjNode] = cost + edgeCost;
                    q.offer(new Pair(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}