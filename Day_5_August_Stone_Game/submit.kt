import kotlin.math.max
/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3870/
 * Stone Game
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1384518/Stone-Game-oror-3-Approaches-oror-1-D-and-2-D-DP-oror-Or-Just-Return-True-oror-C%2B%2B-or-JAVA-or-Python
 */

class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        val size = piles.size
        val dp = Array(size){Array(size){0}}
        for (index in piles.indices) {
            dp[index][index] = piles[index]
        }
        for (d in 1 until size) {
            for (i in 0 until size - d) {
                dp[i][i + d] = max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1])
            }
        }
        return dp[0][size - 1] > 0
    }
}