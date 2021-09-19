/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3980/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1473060/Distinct-Subsequences-or-or-recursion%2B-memoization-or-or-DP-or-or-C%2B%2B-or-or-Clean-and-Concise
 * Distinct Subsequences
 */

class Solution {
    fun numDistinct(s: String, t: String): Int {
        val dp = Array(s.length) { Array(t.length) {-1} }
        return doCount(0, 0, s, t, dp)
    }

    fun doCount(i: Int, j: Int, s: String, t: String, dp: Array<Array<Int>>): Int {
        if (j == t.length) return 1
        if (i == s.length) return 0
        if (dp[i][j] != -1) return dp[i][j]

        var ans = 0
        if (s[i] == t[j])
            ans = doCount(i + 1, j + 1, s, t, dp)

        // case s[i + 1] == t[j]
        ans += doCount(i + 1, j, s, t, dp)
        dp[i][j] = ans
        return ans
    }
}