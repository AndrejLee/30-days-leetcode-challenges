https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3302/

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        boolean[][] matrix = new boolean[m][n];
        
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && matrix[i][j] == false) {
                    count++;
                    expand(grid, m, n, matrix, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void expand(char[][] grid, int m, int n, boolean[][] matrix, int i, int j) {
        matrix[i][j] = true;
        if (j + 1 < n && grid[i][j + 1] == '1' && matrix[i][j + 1] == false) {
            expand(grid, m, n, matrix, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && matrix[i][j - 1] == false) {
            expand(grid, m, n, matrix, i, j - 1);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && matrix[i - 1][j] == false) {
            expand(grid, m, n, matrix, i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1' && matrix[i + 1][j] == false) {
            expand(grid, m, n, matrix, i + 1, j);
        }
    }
}
