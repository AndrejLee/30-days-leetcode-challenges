https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3303/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] mins = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0) {
                mins[i] = mins[i - 1] + grid[0][i];    
            } else {
                mins[i] = grid[0][i];
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) {
                    mins[j] = Math.min(mins[j], mins[j - 1]) + grid[i][j];
                } else {
                    mins[j] = mins[j] + grid[i][j];
                }
            }
        }
        
        return mins[n - 1];
    }
}
