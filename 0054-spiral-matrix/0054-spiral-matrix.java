class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] dx = {0, 1, 0, -1};   
        int[] dy = {1, 0, -1, 0};

        List<Integer> ans = new ArrayList<>();

        int row = 0;
        int col = 0;
        int direction = 0;

        for (int i = 0; i < n * m; i++) {

            ans.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + dx[direction];
            int nextCol = col + dy[direction];

            if (nextRow < 0 || nextRow >= n ||
                nextCol < 0 || nextCol >= m ||
                visited[nextRow][nextCol]) {

                direction = (direction + 1) % 4;

                nextRow = row + dx[direction];
                nextCol = col + dy[direction];
            }

            row = nextRow;
            col = nextCol;
        }

        return ans;
    }
}