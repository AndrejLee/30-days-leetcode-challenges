/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3790/
 * Out of Boundary Paths
 * Ref: https://leetcode.com/discuss/explore/june-leetcoding-challenge-2021/1293836/Out-of-Boundary-Paths-or-Optimization-from-Brute-Force-w-Explanation
 */

class Solution {
    private val dp = Array(50) { Array(50) { Array(51) { -1 } } }
    private val X = intArrayOf(0, -1, 0, 1)
    private val Y = intArrayOf(-1, 0, 1, 0)

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val isOut: Int = isOutBounds(m, n, startRow, startColumn)
        if (isOut == 1 || maxMove == 0) return isOut
        if (dp[startRow][startColumn][maxMove] != -1) return dp[startRow][startColumn][maxMove]
        dp[startRow][startColumn][maxMove] = 0
        for (index in X.indices) {
            dp[startRow][startColumn][maxMove] += findPaths(m, n, maxMove - 1, startRow + X[index], startColumn + Y[index])
            dp[startRow][startColumn][maxMove] = dp[startRow][startColumn][maxMove].rem(1000000007)
        }
        return dp[startRow][startColumn][maxMove]
    }

    fun isOutBounds(m: Int, n: Int, row: Int, column: Int): Int {
        return if (row < 0 || row >= m || column < 0 || column >= n) 1 else 0
    }
}