class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int total = 0;
        int count = 0;

        Queue<int[]> rotten = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    total++;

                if (grid[i][j] == 2)
                    rotten.offer(new int[]{i, j});
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int minutes = 0;

        while (!rotten.isEmpty()) {

            int size = rotten.size();
            count += size;

            for (int i = 0; i < size; i++) {

                int[] curr = rotten.poll();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                        continue;

                    if (grid[nx][ny] != 1)
                        continue;

                    grid[nx][ny] = 2;
                    rotten.offer(new int[]{nx, ny});
                }
            }

            if (!rotten.isEmpty())
                minutes++;
        }

        return total == count ? minutes : -1;
    }
}