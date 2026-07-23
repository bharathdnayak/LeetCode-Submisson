class Pair {
    int row, col, effort;

    Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);

        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int r = cur.row;
            int c = cur.col;
            int effort = cur.effort;

            if (r == n - 1 && c == m - 1)
                return effort;

            if (effort > dist[r][c])
                continue;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort = Math.max(effort, diff);

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}