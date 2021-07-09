import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3808/
 * Longest Increasing Subsequence
 * Ref: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 */

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var result = 1

        val dp = Array(nums.size) { 1 }

        for (upperIndex in nums.indices) {
            for (lowerIndex in 0 until upperIndex) {
                if (nums[upperIndex] > nums[lowerIndex]) {
                    dp[upperIndex] = max(dp[upperIndex], dp[lowerIndex] + 1)
                    result = max(result, dp[upperIndex])
                }
            }
        }

        return result
    }
}