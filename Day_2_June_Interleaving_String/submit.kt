class Solution {
    /**
     *  Solution O(m x n) dp top down
     */
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val m = s1.length
        val n = s2.length
        if (m + n != s3.length)
            return false
        val dp = Array(m + 1) { Array(n + 1) {false} }
        dp[0][0] = true

        for (j in s2.indices) {
            dp[0][j + 1] = dp[0][j] && s2[j] == s3[j]
        }

        for (i in s1.indices) {
            dp[i + 1][0] = dp[i][0] && s1[i] == s3[i]
        }

        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = (s1[i - 1] == s3[i + j - 1] && dp[i - 1][j]) || (s2[j - 1] == s3[i + j - 1] && dp[i][j - 1])
            }
        }
        return dp[m][n]
    }
}