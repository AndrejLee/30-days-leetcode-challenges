/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3809/
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1328400/Decode-Ways-2-or-Get-The-Detailed-Explanation-Here-or-Dp
 * Decode Ways II
 */

class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0
        val mod = 1000000007
        val n = s.length
        val dp = Array(n + 1) { 0L }
        dp[0] = 1
        dp[1] = if (s[0] == '*') 9 else 1
        for (index in 2..n) {
            val curChar = s[index - 1]
            val prevChar = s[index - 2]

            // Case (12)(3)
            if (curChar == '*')
                dp[index] = (9 * dp[index - 1]).rem(mod)
            else if (curChar != '0')
                dp[index] = dp[index - 1].rem(mod)

            // Case (1)(23)
            when (prevChar) {
                '*' -> {
                    when {
                        curChar == '*' -> dp[index] = (dp[index] + (15 * dp[index - 2]).rem(mod)).rem(mod)
                        curChar <= '6' -> dp[index] = (dp[index] + (2 * dp[index - 2]).rem(mod)).rem(mod)
                        else -> dp[index] = (dp[index] + dp[index - 2]).rem(mod)
                    }
                }
                '2' -> {
                    when {
                        curChar == '*' -> dp[index] = (dp[index] + (6 * dp[index - 2]).rem(mod)).rem(mod)
                        curChar <= '6' -> dp[index] = (dp[index] + dp[index - 2]).rem(mod)
                    }
                }
                '1' -> {
                    when {
                        curChar == '*' -> dp[index] = (dp[index] + (9 * dp[index - 2]).rem(mod)).rem(mod)
                        else -> dp[index] = (dp[index] + dp[index - 2]).rem(mod)
                    }
                }
            }
        }

        return dp.last().rem(mod).toInt()
    }
}