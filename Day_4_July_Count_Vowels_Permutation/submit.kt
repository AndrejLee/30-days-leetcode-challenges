/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3802/
 * Count Vowels Permutation
 */

class Solution {
    fun countVowelPermutation(n: Int): Int {
        val mod = 1000000007
        val dp = Array(n + 1) { Array(5) { 0L } }
        for (index in dp[0].indices) {
            dp[1][index] = 1
        }
        for (row in 2 until dp.size) {
            dp[row][0] = (dp[row - 1][1] + dp[row - 1][2] + dp[row - 1][4]).rem(mod)
            dp[row][1] = (dp[row - 1][0] + dp[row - 1][2]).rem(mod)
            dp[row][2] = (dp[row - 1][1] + dp[row - 1][3]).rem(mod)
            dp[row][3] = dp[row - 1][2]
            dp[row][4] = (dp[row - 1][2] + dp[row - 1][3]).rem(mod)
        }

        return dp[dp.size - 1].sum().rem(mod).toInt()
    }
}