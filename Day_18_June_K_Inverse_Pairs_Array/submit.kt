/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3784/
 * K Inverse Pairs Array
 * Ref: https://leetcode.com/discuss/explore/june-leetcoding-challenge-2021/1283053/K-inverse-pairs-oror-C%2B%2B-oror-dp-oror-explained
 */

class Solution {
    fun kInversePairs(n: Int, k: Int): Int {
        var dp = Array(k + 1) { 0L }
        val temp = Array(k + 1) { 0L }
        val mod = 1000000007
        for (i in 1..n) {
            Arrays.fill(temp, 0L)
            temp[0] = 1L
            if (i >= 2) {
                for (j in 1..k) {
                    val redundant = if (j >= i) dp[j - i] else 0
                    // CAREFUL OF SUBTRACT WITH MODULE
                    temp[j] = (temp[j - 1].rem(mod) + (dp[j] + mod - redundant).rem(mod)).rem(mod)
                }
            }
            dp = temp.copyOf()
        }
        return dp[k].rem(mod).toInt()
    }
}