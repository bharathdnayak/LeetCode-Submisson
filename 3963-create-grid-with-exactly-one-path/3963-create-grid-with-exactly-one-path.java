class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for (char[] row : grid) {
            Arrays.fill(row, '#');
        }

        int i = 0, j = 0;

        while (i < m && j < n) {
            grid[i][j] = '.';

            if (j < n - 1) {
                j++; 
            } else if (i < m - 1) {
                i++;
            } else {
                break;
            }
        }

        String[] ans = new String[m];

        for (int r = 0; r < m; r++) {
            ans[r] = new String(grid[r]);
        }

        return ans;
    }
}