/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3902/
 * Decode ways
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1410825/Decode-Ways-oror-3-Approach-w-Explanation-oror-DP-or-Iterative-oror-C%2B%2B-or-Python-or-Java
 */

class Solution {
    fun numDecodings(s: String): Int {
        val dp = Array(s.length + 1) {0}
        dp[dp.size - 1] = 1

        for (index in s.indices.reversed()) {
            if (s[index] == '0') {
                dp[index] = 0
            } else {
                dp[index] = dp[index + 1]
                if (index + 1 < s.length && (s[index] == '1' || (s[index] == '2' && s[index + 1] < '7'))) {
                    dp[index] += dp[index + 2]
                }
            }
        }

        return if (s.isEmpty()) 0 else dp[0]
    }
}