/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3970/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1455560/Arithmetic-Slices-II-oror-DP-W-O(N2)-Approach-oror-C%2B%2B-or-Python
 * Arithmetic Slices II - Subsequence
 */

class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val dp = Array(nums.size) { HashMap<Long, Long>() }
        var ans = 0L
        for (i in nums.indices) {
            for (j in 0 until i) {
                val diff = nums[i].toLong() - nums[j].toLong()
                var count = dp[i][diff]
                if (count == null)
                    count = 0
                dp[i][diff] = count + 1
                if (dp[j].contains(diff)) {
                    dp[i][diff] = dp[i][diff]!! + dp[j][diff]!!
                    ans += dp[j][diff]!!
                }
            }
        }
        return ans.toInt()
    }
}