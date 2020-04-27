https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] map = new int[n + 1][m + 1];
        int res = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    if (map[i - 1][j] == map[i][j - 1] && map[i - 1][j] == map[i - 1][j - 1]) {
                        map[i][j] = map[i - 1][j] + 1;
                    } else {
                        int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                        map[i][j] = min + 1;
                    } 
                    res = Math.max(res, map[i][j]);
                }
            }
        }
        
        return res * res;
    }
}
